package ru.otr.lbss.service.antiddos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cxc.jex.common.application.config.PropertiesService;
import cxc.jex.common.failure.FailureWrapper;
import ru.otr.lbss.service.config.ModeService;
import ru.otr.lbss.service.config.ServiceProperties;
import ru.otr.lbss.service.model.types.SmevMember;

public class AntiDDOS {
	private static Logger log = LoggerFactory.getLogger(AntiDDOS.class);

	public static final String GET_REQUEST = "GetRequest";
	public static final String GET_RESPONSE = "GetResponse";

	@Autowired
	private ModeService modeService;
	@Autowired
	private PropertiesService propertiesService;

	private final Map<String, Long> lastCallTime = new ConcurrentHashMap<>();
	private final Map<String, List<Long>> statistics = new ConcurrentHashMap<>();

	private int counter;
	private long allowedPeriod;

	@PostConstruct
	private void init() {
		log.info("init");
		counter = propertiesService.getInteger(ServiceProperties.AntiDDOS_counter, 10);
		allowedPeriod = propertiesService.getLong(ServiceProperties.AntiDDOS_allowedPeriod, 30000);
	}

	private boolean isEnable() {
		return modeService.isAntiDDOSEnable();
	}

	private void check(SmevMember memeber, String queueName, long callTime) throws FailureWrapper {
		if (isEnable()) {
			String key = memeber.getMnemonic() + "-" + queueName;
			Long lct = lastCallTime.get(key);
			lastCallTime.put(key, callTime);
			if (lct != null) {
				List<Long> stat = statistics.get(key);
				if (stat != null) {
					stat.add(callTime - lct);
					if (stat.size() > counter) {
						long am = 0;
						for (int i = stat.size() - 1; i > stat.size() - 1 - counter; i--) {
							am += stat.get(i) / counter;
						}
						if (am > allowedPeriod) {
							return;
						}
						long sd = 0;
						for (int i = stat.size() - 1; i > stat.size() - 1 - counter; i--) {
							sd += ((stat.get(i) - am) * (stat.get(i) - am)) / counter;
						}
						sd = (long) Math.sqrt(sd);
						if (sd < (am / 2)) {
							log.warn("DDOS from " + memeber.getMnemonic());
							throw new FailureWrapper("SMEV.AccessDenied.DDOS", memeber.getHumanReadableName());
						} else {
							stat.clear();
						}
					} else {
					}
				} else {
					stat = new ArrayList<>();
					stat.add(callTime - lct);
					statistics.put(key, stat);
				}
				log.debug("AntiDDOS(" + key + ") statistics=" + stat.toString());
			}
		}
	}

	public synchronized void checkGetRequest(SmevMember memeber, long callTime) throws FailureWrapper {
		check(memeber, GET_REQUEST, callTime);
	}

	public synchronized void checkGetResponse(SmevMember memeber, long callTime) throws FailureWrapper {
		check(memeber, GET_RESPONSE, callTime);
	}

	private void reset(SmevMember memeber, String queueName) {
		if (isEnable()) {
			String key = memeber.getMnemonic() + "-" + queueName;
			log.debug("AntiDDOS(" + key + ") reset");
			lastCallTime.remove(key);
			statistics.remove(key);
		}
	}

	public synchronized void resetGetRequest(SmevMember memeber) {
		reset(memeber, GET_REQUEST);
	}

	public synchronized void resetGetResponse(SmevMember memeber) {
		reset(memeber, GET_RESPONSE);
	}

}
