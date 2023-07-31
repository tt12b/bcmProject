package ywluv.bcmProject.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 인증 성공시 핸들러
 */
@Component
@Slf4j
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        setDefaultTargetUrl("/");

        /*사용자가 인증에 성공하기 전, 요청했던 정보를 담고 있던 객체 */
        SavedRequest savedRequest = requestCache.getRequest(request, response);

        /*인증 전 요청 정보가 담겨있는 경우 */
        if ( savedRequest != null ) {
            /*사용자가 인증 받기 전 가고자 했던 url로 보낸다*/
            String targetUrl = savedRequest.getRedirectUrl();
            redirectStrategy.sendRedirect(request, response, targetUrl);
            log.info("인증 성공 / 이동할 url : "+targetUrl);

            //SavedRequest가 존재하지 않는 경우,
            // 는 사용자가 인증을 하기 전에 다른 자원에 접근했을 때, 인증 예외가 발생해서 다시 로그인 페이지로 이동했을 때
        } else {
            redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
            log.info("인증 성공 / 이동할 url : "+getDefaultTargetUrl());

        }



    }
}
