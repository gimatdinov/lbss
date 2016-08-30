package ru.otr.lbss.service.ftp;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.ftpserver.ftplet.Authentication;
import org.apache.ftpserver.ftplet.AuthenticationFailedException;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.User;
import org.apache.ftpserver.usermanager.UsernamePasswordAuthentication;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import cxc.jex.common.exception.ExceptionWrapper;

public class FTPUserManager implements org.apache.ftpserver.ftplet.UserManager {
	private static Logger log = LoggerFactory.getLogger(FTPUserManager.class);

	private final String ftpDirectory;
	private final MongoClient mongoClient;
	private final MongoDatabase usersDB;
	private final Map<String, FTPUser> notStoredUsers;
	private final String userDocName;

	private final String adminName = "admin";

	public FTPUserManager(String ftpDirectory, String mongoHost, int mongoPort, String dbName, String userDocName, String adminPassword)
	        throws ExceptionWrapper {
		log.info("init");
		if (ftpDirectory == null || mongoHost == null || dbName == null || mongoPort <= 0 || userDocName == null) {
			throw new IllegalArgumentException();
		}
		this.ftpDirectory = ftpDirectory;
		this.userDocName = userDocName;
		this.notStoredUsers = new HashMap<>();

		log.info("MongoDB : " + mongoHost + ":" + mongoPort);
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		FTPUserCodec ftpUserCodec = new FTPUserCodec(defaultDocumentCodec, ftpDirectory);
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromCodecs(ftpUserCodec));
		MongoClientOptions mongoOptions = MongoClientOptions.builder().codecRegistry(codecRegistry).build();

		mongoClient = new MongoClient(mongoHost + ":" + mongoPort, mongoOptions);
		usersDB = mongoClient.getDatabase(dbName);

		FTPUser admin = new FTPUser(adminName, adminPassword, ftpDirectory, ".", true);
		notStoredUsers.put(admin.getName(), admin);
	}

	public void close() {
		mongoClient.close();
	}

	@Override
	public User authenticate(Authentication _auth) throws AuthenticationFailedException {
		if (_auth instanceof UsernamePasswordAuthentication) {
			UsernamePasswordAuthentication auth = (UsernamePasswordAuthentication) _auth;
			MongoCollection<FTPUser> collection = usersDB.getCollection(userDocName, FTPUser.class);
			FTPUser user = collection.find(and(eq("Name", auth.getUsername().toLowerCase()), (eq("Password", auth.getPassword())))).first();
			if (user != null) {
				prepareUserFolder(user);
			}
			if (user == null) {
				user = notStoredUsers.get(auth.getUsername().toLowerCase());
				if (user != null && !user.getPassword().equals(auth.getPassword())) {
					user = null;
				}
			}
			return user;
		}
		return null;
	}

	@Override
	public void delete(String userName) throws FtpException {
		MongoCollection<FTPUser> collection = usersDB.getCollection(userDocName, FTPUser.class);
		FTPUser user = collection.findOneAndDelete(eq("Name", userName.toLowerCase()));
		if (user == null) {
			user = notStoredUsers.remove(userName.toLowerCase());
		}
		if (user != null) {
			new File(ftpDirectory, user.getFolder()).delete();
		}
	}

	@Override
	public boolean doesExist(String userName) throws FtpException {
		FTPUser user = usersDB.getCollection(userDocName, FTPUser.class).find(eq("Name", userName.toLowerCase())).first();
		if (user == null) {
			user = notStoredUsers.get(userName.toLowerCase());
		}
		return (user != null);
	}

	@Override
	public String getAdminName() throws FtpException {
		return adminName;
	}

	@Override
	public String[] getAllUserNames() throws FtpException {
		// TODO FTPUserManager.getAllUserNames()
		return null;
	}

	@Override
	public User getUserByName(String userName) throws FtpException {
		FTPUser user = usersDB.getCollection(userDocName, FTPUser.class).find(eq("Name", userName.toLowerCase())).first();
		if (user == null) {
			user = notStoredUsers.get(userName.toLowerCase());
		}
		if (user != null) {
			prepareUserFolder(user);
		}
		return user;
	}

	@Override
	public boolean isAdmin(String userName) throws FtpException {
		return (adminName.equals(userName));
	}

	@Override
	public void save(User user) throws FtpException {
		if (user instanceof FTPUser) {
			FTPUser ftpUser = (FTPUser) user;
			prepareUserFolder(ftpUser);
			usersDB.getCollection(userDocName, FTPUser.class).insertOne(ftpUser);
		} else {
			throw new FtpException("Unsupported class: " + user.getClass().getName());
		}
	}

	public User save(String name, String password, String folder, boolean writePermission, boolean store) throws FtpException {
		FTPUser result = new FTPUser(name, password, ftpDirectory, folder, writePermission);
		if (store) {
			save(result);
		} else {
			notStoredUsers.put(result.getName(), result);
			prepareUserFolder(result);
		}
		return result;
	}

	private void prepareUserFolder(FTPUser user) {
		File dir = new File(ftpDirectory, user.getFolder());
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	public String getFtpDirectory() {
		return ftpDirectory;
	}

}
