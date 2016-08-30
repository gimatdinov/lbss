package ru.otr.lbss.service.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cxc.jex.common.application.config.ConfigService;
import ru.otr.lbss.service.SmevFTPService;
import ru.otr.lbss.service.SmevSignService;
import ru.otr.lbss.service.api.SmevPrimeServiceLocal;

public class LbssModeService {
	private static Logger log = LoggerFactory.getLogger(LbssModeService.class);

	@Autowired
	private ConfigService configService;

	private SmevPrimeServiceLocal.Mode primeServiceMode;
	private SmevSignService.Mode signServiceMode;
	private SmevFTPService.Mode ftpServiceMode;

	@PostConstruct
	private void init() {
		log.info("init");
		try {

			primeServiceMode = SmevPrimeServiceLocal.Mode
			        .valueOf(configService.getString(LbssConfig.PrimeService_mode, SmevPrimeServiceLocal.Mode.LIVE.toString()));
			log.info("PrimeServiceMode : " + primeServiceMode.toString());

			signServiceMode = SmevSignService.Mode.valueOf(configService.getString(LbssConfig.SignService_mode, SmevSignService.Mode.STUB.toString()));
			log.info("SignServiceMode : " + signServiceMode.toString());

			ftpServiceMode = SmevFTPService.Mode.valueOf(configService.getString(LbssConfig.FTPService_mode, SmevFTPService.Mode.MOVE.toString()));
			log.info("FTPServiceMode : " + ftpServiceMode.toString());

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SmevPrimeServiceLocal.Mode getPrimeServiceMode() {
		return primeServiceMode;
	}

	public SmevSignService.Mode getSignServiceMode() {
		return signServiceMode;
	}

	public SmevFTPService.Mode getFtpServiceMode() {
		return ftpServiceMode;
	}

}
