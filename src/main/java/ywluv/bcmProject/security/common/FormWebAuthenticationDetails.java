package ywluv.bcmProject.security.common;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * Authentication : 인증객체, 사용자의 요청을 받으면 AuthenticationFilter(ex : UsernamePasswordAuthenticationFilter)가 요청을 받아 Authentication객체를 생성 , 인증 객체는 details라는 속성을 가지고 있음. details속성 안에는 WebAuthenticationDetails라는 클래스 객체가 저장되어 있음
 * WebAuthenticationDetails : 인증 과정에서 username/password 외, 추가 정보를 인증&과정속에서 활용하거나 인증 후에도 참조해서 사용할 수 있도록 처리하는 클래스
 * AuthenticationDetailsSource : WebAuthenticationDetails 객체를 생성하는 클래스
 */
public class FormWebAuthenticationDetails extends WebAuthenticationDetails {

    private String secretkey;

    public FormWebAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.secretkey = request.getParameter("secret_key");
    }

    public String getSecretkey() {
        return secretkey;
    }
}
