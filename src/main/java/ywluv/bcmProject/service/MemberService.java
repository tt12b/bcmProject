package ywluv.bcmProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.config.CustomYml;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.*;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.repository.Deposit.DepositHistoryRepository;
import ywluv.bcmProject.repository.member.MemberRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ywluv.bcmProject.config.CustomYml.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final DepositHistoryRepository depositHistoryRepository;


    /**
     * test멤버 생성
     */
    @Transactional
    public Member createTestMember(){
        Member saveMember = memberRepository.save(new Member("테스트계정", "테스트계정"));
        return saveMember;
    }
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
     * @return Member
     */
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다. :" + memberId));
    }

    /**
     * 금액만 조회
     * @Param Long memberId
     * @Return int userDeposit
     */
    public int getDeposit(Long memberId){
        return memberRepository.findDepositById(memberId);
    }

    /**
     * 입금
     * @Param Long memberId
     * @Return int userDeposit
     */
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int depositMoney(Long memberId,int amount, String reason){
        Member findMember = findById(memberId);
        int newDeposit = findMember.getDeposit() + amount;
            if (newDeposit <= -getNegativeDepositLimit()) {
                throw new IllegalArgumentException("예치금이 마이너스 "+-getNegativeDepositLimit()+"원 이하가 될 수 없습니다.");
            }
        depositHistoryRepository.save(DepositHistory.createDepositHistory(findMember,amount,reason));

            //JPQL로 조회했을 경우... 영속성 컨텍스트안 값이라 다르니 잘 비교해서..
//        Long totalDepositOfMember = depositHistoryRepository.getTotalDepositOfMember(1L);
//        Long totalDeposit = depositHistoryRepository.getTotalDeposit();


        findMember.updateDeposit(newDeposit);
        //기록과 비교하기
        return newDeposit;
    }

    public Member dtoToEntity(MemberDto memberDto){


        Member member = new Member(
                memberDto.getUserNickName()
            ,   memberDto.getUserName()
            ,   memberDto.getPassword()
            ,   AddressType.valueOf(memberDto.getAddressType())
            ,   memberDto.getDeposit()
            ,   null
        );
        return member;
    }

}
