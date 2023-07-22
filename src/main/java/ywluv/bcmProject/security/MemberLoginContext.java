package ywluv.bcmProject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ywluv.bcmProject.entity.Member;

import java.util.Collection;


//UserDetails의 구현체 User 클래스 상속받아 사용
//LoginService에서 로그인 확인 후, 해당 구현체를 리턴
public class MemberLoginContext extends User {

    private final Member member;

    /**
     * 로그인 시 계정 정보 생성
     * @param member
     * @param authorities
     */
    public MemberLoginContext(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getUserNickName(),member.getPassword(), authorities);
        System.out.println("확인중ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
        System.out.println(authorities);
        this.member = member;
    }

    public Member getMember(){
        return member;
    }

}
