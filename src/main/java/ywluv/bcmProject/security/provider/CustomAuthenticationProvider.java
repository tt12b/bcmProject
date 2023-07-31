package ywluv.bcmProject.security.provider;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import ywluv.bcmProject.security.LoginService;
import ywluv.bcmProject.security.MemberLoginContext;
import ywluv.bcmProject.security.common.FormWebAuthenticationDetails;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomAuthenticationProvider(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    /**
     * 인증에 관한 검증 처리
     * */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String userNickName = authentication.getName();
        String password = (String) authentication.getCredentials();


        System.out.println(2);
        MemberLoginContext memberLoginContext = (MemberLoginContext) loginService.loadUserByUsername(userNickName);


        System.out.println(3);
        //사용자가 입력한 비밀번호, 멤버로그인컨텍스트(UserDetails)에서 찾은 멤버(db에 저장된)가 가지고 있는 비밀번호 비교
        if ( !passwordEncoder.matches( password, memberLoginContext.getMember().getPassword() ) ) {
            throw new BadCredentialsException( "Invalid Password" );
        }


        /*
         WebAuthenticationDetails테스트용 secretKey
         */

        //Authentiocan(인증객체에서)에서 details속성을 가져온다.
        //details속성 안에는 WebAuthenticationDetails을 클래스 객체가 저장되어 있으므로 details속성을 WebAuthenticationDetails의 구현체인 FromWebAuthenticationDetails클래스로 형변환하여 받는다.
        FormWebAuthenticationDetails formWebAuthenticationDetails = (FormWebAuthenticationDetails)authentication.getDetails();

        String secretkey = formWebAuthenticationDetails.getSecretkey();

        if(secretkey == null || !secretkey.equals("secret키값")){
            System.out.println("시크릿키 :" +secretkey);
            throw  new InsufficientAuthenticationException("WebAuthenticationDetails 내부 값 불일치");
        }


        return new UsernamePasswordAuthenticationToken(memberLoginContext.getMember(), null, memberLoginContext.getAuthorities());

    }


    // 현재 인증객체가 어떤 타입인지 체크, 토큰 타입과 일치할 때 인증
    //UsernamePasswordAuthenticationToken 사용자 이름과 비밀번호를 포함하는 인증 객체
    // AuthenticationProvider가 처리할 수 있는지 여부를 체크,
    // supports 값이 false를 리턴하면, 프로바이더의 authenticate 메소드가 호출되지 않는다.
    @Override
    public boolean supports(Class<?> authentication) {

//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);

    }

}
