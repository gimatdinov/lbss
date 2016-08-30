package ru.otr.lbss.service.config;

public interface LbssConfig {
    final static String jaxb_context_path = "LBSS.service.jaxb_context_path";

    final static String PrimeService_mode = "LBSS.service.PrimeService_mode";
    final static String SignService_mode = "LBSS.service.SignService_mode";
    final static String FTPService_mode = "LBSS.service.FTPService_mode";

    final static String mongo_host = "LBSS.service.mongo_host";
    final static String mongo_port = "LBSS.service.mongo_port";
    final static String mongo_db_messages = "LBSS.service.mongo_db_messages";
    final static String mongo_db_members = "LBSS.service.mongo_db_members";

    final static String ftp_directory = "LBSS.service.ftp_directory";
    final static String ftp_port = "LBSS.service.ftp_port";
    final static String ftp_admin_password = "LBSS.service.ftp_admin_password";
    final static String ftp_log_enable = "LBSS.service.ftp_log_enable";
    final static String ftp_users_list = "LBSS.service.ftp_users_list";
    final static String ftp_users_database = "LBSS.service.ftp_users_database";

    final static String PrimeService_acknowledgmentTimeout = "LBSS.service.PrimeService_acknowledgmentTimeout";

    final static String SignService_cryptoWebServiceURI = "LBSS.service.SignService_cryptoWebServiceURI";

}
