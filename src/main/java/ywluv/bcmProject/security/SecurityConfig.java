package ywluv.bcmProject.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 됨
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http.authorizeHttpRequests()
                .requestMatchers("/error","/sbadmin/**","/login", "/logout").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/", true);


//                 hasAnyRole : 여러 역할에 대한 확인
//                .requestMatchers("/admin/**").hasAnyRole("MANAGER", "ADMIN")
//                hasRole:단일 역할에 대한 확인
//                .requestMatchers("/admin/**").hasRole("ADMIN")
        return http.build();
    }

}