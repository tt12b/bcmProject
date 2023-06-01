package ywluv.bcmProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import ywluv.bcmProject.config.AuditConfig;

import java.util.Optional;


@EnableJpaAuditing
@SpringBootApplication
public class BcmProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(BcmProjectApplication.class, args);
	}

}
