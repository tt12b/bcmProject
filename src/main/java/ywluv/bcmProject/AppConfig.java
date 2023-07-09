package ywluv.bcmProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistryImpl;
import ywluv.bcmProject.aspect.TimeTraceAop;
import ywluv.bcmProject.controller.form.MemberForm;
import ywluv.bcmProject.validator.PasswordValidator;

@Configuration
public class AppConfig {

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

    @Bean
    public SessionRegistryImpl sessionRegistry() {
        return new SessionRegistryImpl();
    }

}
