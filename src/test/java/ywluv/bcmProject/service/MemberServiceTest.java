package ywluv.bcmProject.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired EntityManager entityManager;
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
}