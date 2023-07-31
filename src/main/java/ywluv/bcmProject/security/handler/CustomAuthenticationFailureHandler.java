package ywluv.bcmProject.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 인증 실패시 핸들러
 */
@Component
@Slf4j
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {


    @Override  //인증 예외를 파라미터로 전달 받음 , 인증 실패 시 예외 발생
    //보통 AuthenticationProvider 또는 UserDetailsService에서 검증이 실패하면 해당 예외를 인증필터가 받아서 파라미터로 전달
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String errorMessage = "Invalid Username or Password";
        String url = "/";
        //사용자가 잘못된 비밀번호를 입력했을 때
        if ( exception instanceof BadCredentialsException ) {
            errorMessage = "Invalid Username or Password";
            setDefaultFailureUrl("/login?error=true&exception="+errorMessage);
        //권한이 없는 리소스에 접근하려고 할 때
        } else if ( exception instanceof InsufficientAuthenticationException ) {
            errorMessage = "권한이 없는 리소스";
            setDefaultFailureUrl("/AuthenticationError?exception="+exception+"&errorMessage="+ errorMessage);
        } else {
            errorMessage = exception.getMessage();
            setDefaultFailureUrl("/AuthenticationError?exception="+exception+"&errorMessage="+ errorMessage);
        }



        log.info("로그인 실패 핸들러 : "+errorMessage);
        log.info("로그인 실패 핸들러 : "+exception.getMessage());
        //처리 위임
        super.onAuthenticationFailure(request, response, exception);

    }
}
