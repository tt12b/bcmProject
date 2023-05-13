package ywluv.bcmProject.repository.Deposit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.service.MemberService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DepositHistoryRepositoryTest {
    @Autowired DepositHistoryRepository depositHistoryRepository;
    @Autowired MemberService memberService;
    @Test
    public void basicTest(){
        Member findMember = memberService.findById(1L);
        System.out.println(findMember.toString());
        System.out.println("변경 전  : "+ findMember.getDeposit());
        memberService.depositMoney(1L,1500,"콕비");
        memberService.depositMoney(1L,1500,"콕비");
        memberService.depositMoney(1L,15000,"예치금");



        Long totalDepositOfMember = depositHistoryRepository.getTotalDepositOfMember(1L);
        Long totalDeposit = depositHistoryRepository.getTotalDeposit();

        System.out.println("===================");
        System.out.println("totalDepositOfMember = " + totalDepositOfMember);
        System.out.println("totalDeposit = " + totalDeposit);

    }
}