package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Deposit;
import ywluv.bcmProject.entity.DepositHistory;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.repository.Balance.DepositHistoryRepository;
import ywluv.bcmProject.repository.Balance.DepositRepository;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepositService {

    @Autowired MemberService memberService;
    @Autowired DepositRepository depositRepository;
    @Autowired DepositHistoryRepository depositHistoryRepository;

    /*
            1. 돈을 입금한다 멤버, 돈(+-), 사유
            2. DepositHistory에 이력을 만든다.
     */
    public void updateDeposit(Long memberId, int mount, String reason){
        Member findMember = memberService.findById(memberId);
        Deposit memberDeposit = depositRepository.findByMember(findMember);

        //디포짓이 아예 없으면?
        System.out.println(memberDeposit.getId());
        //테스트해보고 이어서 작성


    }
}
