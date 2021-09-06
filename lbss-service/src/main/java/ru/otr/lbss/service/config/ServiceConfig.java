package ru.otr.lbss.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.otr.lbss.client.api.SmevPrimeServiceLocal;
import ru.otr.lbss.service.SmevFTPService;
import ru.otr.lbss.service.SmevMemberService;
import ru.otr.lbss.service.SmevPrimeService;
import ru.otr.lbss.service.SmevProcessingService;
import ru.otr.lbss.service.SmevSignService;
import ru.otr.lbss.service.SmevValidationService;
import ru.otr.lbss.service.antiddos.AntiDDOS;
import ru.otr.lbss.service.model.config.ModelConfig;

@Configuration
@Import(ModelConfig.class)
public class ServiceConfig {
	@Bean
	ModeService getModeService() {
		return new ModeService();
	};

	@Bean
	SmevPrimeServiceLocal getSmevPrimeService() {
		return new SmevPrimeService();
	};



	@Bean
	SmevMemberService getSmevMemberService() {
		return new SmevMemberService();
	}

	@Bean
	SmevSignService getSmevSignService() {
		return new SmevSignService();
	};

	@Bean
	SmevFTPService getSmevFTPService() {
		return new SmevFTPService();
	};

	@Bean
	SmevProcessingService getSmevProcessingService() {
		return new SmevProcessingService();
	}

	@Bean
	SmevValidationService getSmevValidationService() {
		return new SmevValidationService();
	}

	@Bean
	AntiDDOS getAntiDDOS() {
		return new AntiDDOS();
	}
}
