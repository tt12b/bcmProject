package ywluv.bcmProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.repository.member.MemberRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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


    /**
     * 회원 PK로 조회
     * @return
     */
    public Member findById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다." + id));
    }
}


