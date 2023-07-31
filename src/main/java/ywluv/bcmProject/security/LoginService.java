package ywluv.bcmProject.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.exceptions.UserNotFoundException;
import ywluv.bcmProject.repository.member.MemberRepository;
import ywluv.bcmProject.security.MemberLoginContext;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;


    @Override
    public UserDetails loadUserByUsername(String userNickName) throws UsernameNotFoundException {

        Member member = memberRepository.findByUserNickName(userNickName)
                .orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다.", userNickName));
        // 추후 할 일
        // 1.UserNotFoundException 예외 발생 시 리다이렉트 처리할 것 & 파라미터 통해서 alert메시지
        // 2. AuthenticationFailHandler  발생 시, alert으로메시지
        // 3. 그 외 예외 처리(권한이 없는 페이지) 발생 시 별도 커스텀 에러 생성& 에러페이지로 이동시킬것
        
        //권한 부여
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole()));
        MemberLoginContext memberLoginContext = new MemberLoginContext(member,roles);
        System.out.println(memberLoginContext.getAuthorities());
        return memberLoginContext;
    }
}
