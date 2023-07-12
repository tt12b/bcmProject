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
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        System.out.println(1);
        String userNickName = authentication.getName();
        String password = (String) authentication.getCredentials();



        System.out.println(2);
        MemberLoginContext memberLoginContext = (MemberLoginContext) loginService.loadUserByUsername(userNickName);


        System.out.println(3);
        if ( !passwordEncoder.matches( password, memberLoginContext.getMember().getPassword() ) ) {
            throw new BadCredentialsException( "Invalid Password" );
//            throw new BadCredentialsException( "BadCredentialsException" );
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
        return new UsernamePasswordAuthenticationToken(memberLoginContext.getMember(), null, memberLoginContext.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
//        return UsernamePasswordAuthenticationToken.class.isAssignableFrom( authentication );
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
