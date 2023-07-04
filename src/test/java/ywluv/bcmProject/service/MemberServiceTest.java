package ywluv.bcmProject.service;

import groovy.util.logging.Slf4j;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.ClubDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.MemberClub;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static ywluv.bcmProject.entity.MemberClub.*;

@SpringBootTest
@Transactional
@Slf4j
@Commit
class MemberServiceTest {

    @Autowired EntityManager em;
    @Autowired MemberService memberService;
    @Autowired ClubService clubService;
    @Autowired MemberClubService memberClubService;


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
    public void dtoToEntityTest(){

        Member member = memberService.findById(1L);


        MemberDto memberDto = member.toDto();

        System.out.println(memberDto);


    }
}