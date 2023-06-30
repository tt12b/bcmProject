package ywluv.bcmProject.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private SessionRegistry sessionRegistry;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http.authorizeHttpRequests()
                //인가
                .requestMatchers("/error","/sbadmin/**","/login", "/logout","/test").permitAll()
                .anyRequest().authenticated()

                //인증 방식
                .and()
                .formLogin() //폼 로그인 방식
//                .loginPage("/login") // 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/", false) // 로그인 성공 후 원래 페이지로 리다이렉트
                .failureUrl("/login") //로그인 실패 시 이동할 경로
                .usernameParameter("userId") // 아이디 파라미터 설정
                .passwordParameter("password") //패스워드 파라미터 설정
                .loginProcessingUrl("/login") // 로그인 프로세스 url
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        log.info("인증 성공 authentication : " +authentication.getName()); //인증에 성공한 유저 체크
                        response.sendRedirect("/");
                    }
                }) // 로그인 성공 후 핸들러
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        log.info("인증실패 exception : "+ exception.getMessage());
                        response.sendRedirect("/login");
                    }
                }) //로그인 실패시 핸들러

                .and()
                .sessionManagement()
                .maximumSessions(1000) //동시 로그인 세션 수
                .expiredUrl("/login")  //세션 만료시
                .sessionRegistry(sessionRegistry) // 세션관리 추후 구현
                ;

        return http.build();
    }

}