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

        //권한 부여
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole()));
        MemberLoginContext memberLoginContext = new MemberLoginContext(member,roles);

        return memberLoginContext;
    }
}
