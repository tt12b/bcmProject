package ywluv.bcmProject.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import ywluv.bcmProject.entity.Member;

import java.util.Collection;

public class MemberLoginContext extends User {

    private final Member member;


    /**
     * 로그인 시 계정 정보 생성
     * @param member
     * @param authorities
     */
    public MemberLoginContext(Member member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getUserNickName(),member.getUserName(), authorities);
        this.member = member;
    }

    public Member getMember(){
        return member;
    }


}
