package ywluv.bcmProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Profile("live")
@Configuration
public class AuditConfig implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("미구현");
    }

    @Bean
    public AuditorAware<String> auditorProvider(){
        return () -> getCurrentAuditor();
    }
}
