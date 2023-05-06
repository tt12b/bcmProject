package ywluv.bcmProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.repository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 멤버 추가(회원 가입)
     * @Param Member
     * @Return Long Id
     */
    @Transactional
    public Long join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 회원 전체 조회
     * @Return List<Member>
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 회원 이름으로 조회
     * @Param String userName
     * @Return Member
     */
    public List<Member> findByUsername(String userName){
        return memberRepository.findByUserName(userName);
    }


}


