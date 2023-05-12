package ywluv.bcmProject.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class MemberServiceTest {

    @Autowired EntityManager em;
    @Autowired MemberService memberService;

    @Test
    public void basicTest(){

        System.out.println("=========테스트 시작==============");
        List<Member> members = memberService.findMembers();
        for (Member member : members) {
            System.out.println("member = " + member);


        }
        System.out.println("=========테스트 종료==============");

    }

    @Test
    public void basicTest2(){

        System.out.println("===베이직 테스트 2 시작 ====");
        Member findMember = memberService.findById(100L);
//        System.out.println("===11111111111111111111==========");
//        System.out.println(findMember.getMemberClubs());
//        System.out.println("===22222222222222222==========");
//        System.out.println("deposit = " + findMember.getDeposit());
//        System.out.println("===베이직 테스트 2 종료 ====");

    }

    @Test
    public void basicTest3(){

        System.out.println("====================================");
        Member findMember = memberService.findById(1L);
        System.out.println(findMember.toString());
        System.out.println("변경 전  : "+ findMember.getDeposit());
        memberService.depositMoney(1L,1500,"콕비");
        memberService.depositMoney(1L,1500,"콕비");
        memberService.depositMoney(1L,15000,"예치금");


//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            memberService.depositMoney(1L,-1000,"콕비");
//        });

//        int deposit = memberService.getDeposit(1L);


    }
}