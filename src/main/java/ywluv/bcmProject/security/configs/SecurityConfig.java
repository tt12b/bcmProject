package ywluv.bcmProject.security.configs;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.transform.stc.SignatureCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

import java.io.IOException;
import java.security.cert.Extension;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Autowired
    private SessionRegistry sessionRegistry;

    //스프링 시큐리티에서 제공하는 인터페이스
    // 사용자 계정을 담당하는 기능 정의
    @Bean  //userDetailsManager 빈으로 등록
    public UserDetailsManager userDetailsManager() {
        String password = passwordEncoder().encode("1234");

        //스프링 시큐리티에서 사용자 정보를 나타내는 인터페이스
        UserDetails user = User.builder()   // User클래스, UserDetails 인터페이스를 구현한 구체적인 구현체. User 클래스는 사용자의 인증 정보를 담고 있는 객체
                .username( "user" )
                .password( password )
                .roles( "USER" )
                .build();
        /*비밀번호의 우선순위는 UserDetailsManager>application.yml. */


        UserDetails manager = User.builder()
                .username("manager")
                .password( password )
                .roles("MANAGER","USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password( password )
                .roles("ADMIN", "MANAGER", "USER")
                .build();

//        nMemoryUserDetailsManager는 스프링 시큐리티에서 제공하는 사용자 정보를 메모리에 저장하고 관리하는 클래스입니다. 이 클래스를 사용하면 애플리케이션의 사용자 정보를 정적으로 관리할 수 있습니다.
//        테스트용으로 사용
        return new InMemoryUserDetailsManager( user, manager, admin );   //InMemoryUserDetailsManager 초기화 되면서, InMemoryUserDetailsManager 생성자 통해 초기화 작업 수행
    }


    // image, js, css 등의 정적 파일을 시큐리티가 필터하지 않도록 설정
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> {
//            web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//            web.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error");
//        };

            /*requestMatchers().permitAll()과 달리 보안필터 자체를 거치지 않는다.*/
            return (web) ->  web.ignoring()
                    .requestMatchers("/css/**")
                    .requestMatchers("/font/**")
                    .requestMatchers("/img/**")
                    .requestMatchers("/sbadmin/**");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        /*
        ex  : passwordEncoder().encode("1234"); // 인코드
            : passwordEncoder().matches("1234",encodePassword); // 패스워드 비교
        * */

    }

    /*시큐리티 인가 및 인증*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        //인가
        /*http.csrf().disable();*/
        http
                .authorizeHttpRequests()
//                .requestMatchers("/error","/sbadmin/**","/login", "/logout","/test").permitAll()  //추후 webSecurityCustomizer 로 수정
                .requestMatchers("/user/**").hasRole("USER")
                .requestMatchers("/manager/**").hasRole("MANAGER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers(new IpAddressMatcher("127.0.0.1")).permitAll()
                .anyRequest().authenticated();


                //인증 방식
        http
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