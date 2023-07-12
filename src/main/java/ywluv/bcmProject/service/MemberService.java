package ywluv.bcmProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.ClubDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.*;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.exceptions.UserAlreadyExistsException;
import ywluv.bcmProject.exceptions.UserNotFoundException;
import ywluv.bcmProject.repository.Deposit.DepositHistoryRepository;
import ywluv.bcmProject.repository.member.MemberRepository;

import java.util.List;

import static ywluv.bcmProject.config.CustomYml.*;
import static ywluv.bcmProject.entity.MemberClub.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final DepositHistoryRepository depositHistoryRepository;
    private final MemberClubService memberClubService;
    private final ClubService clubService;


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
    public Long createUser(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 멤버 추가(회원 가입)
     * @Param Member
     * @Return Long Id
     */
    @Transactional
    //회원 가입시 닉네임 중복 여부 기능 추가 필요
    public Long createUser(MemberDto memberDto){
        String userNickName = memberDto.getUserNickName();

        memberRepository.findByUserNickName(userNickName)
                .ifPresent(m -> {
                    throw new UserAlreadyExistsException("이미 존재하는 회원입니다. : "+userNickName,userNickName);
                });


        Member newMember = new Member(
                    memberDto.getUserNickName()
                ,   memberDto.getUserName()
                ,   memberDto.getPassword()
                ,   (memberDto.getAddressType() != null ) ? AddressType.valueOf(memberDto.getAddressType()) : null
                ,   0
        );

        memberRepository.save(newMember);

        if(memberDto.getClubList() != null){
            List<ClubDto> clubList = memberDto.getClubList();
            for (ClubDto clubDto : clubList) {
                memberClubService.save( joinClub(newMember,clubService.findById(clubDto.getId())));
            }
        }

        return newMember.getId();
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
     * 회원 닉네임으로 조회
     * @Param String userNickName
     * @Return Member
     */
    public Member findByUserNickName(String UserNickName){
        return memberRepository.findByUserNickName(UserNickName)
                .orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다.",UserNickName));
    }


    /**
     * 회원 PK로 조회
     * @return Member
     */
    public Member findById(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new UserNotFoundException("회원을 찾을 수 없습니다. :" + memberId, memberId));

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
}
