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


        System.out.println(4);

        // 시크릿 키 인증
//        String secretKey = ( (FormWebAuthenticationDetails) authentication.getDetails() ).getSecretkey();

//        FormWebAuthenticationDetails formWebAuthenticationDetails = (FormWebAuthenticationDetails) authentication.getDetails();
        System.out.println(5);
//        String secretKey = formWebAuthenticationDetails.getSecretkey();
        System.out.println(6);
//        if (secretkey == null || !"secret".equals(secret_key)) {

        //시크릿키 임시로.. 주석
//        String secretKey = ( (FormWebAuthenticationDetails) authentication.getDetails() ).getSecretkey();
//        if (secretKey == null || !secretKey.equals("secret_key")) {
////            throw new InsufficientAuthenticationException("InsufficientAuthenticationException");
//            throw new InsufficientAuthenticationException("invalid Secret");
//        }
//        //시크릿키 임시로.. 주석

        System.out.println(7);
        System.out.println("권한체크으으으으-=-");
        System.out.println(memberLoginContext.getAuthorities());
//        return new UsernamePasswordAuthenticationToken(memberLoginContext.getMember(), password, memberLoginContext.getAuthorities());
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
