package ywluv.bcmProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import ywluv.bcmProject.aspect.TimeTraceAop;

@Configuration
public class AppConfig {

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }


}
