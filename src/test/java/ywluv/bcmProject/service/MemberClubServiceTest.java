package ywluv.bcmProject.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.dto.MemberDto;

import javax.swing.text.html.parser.Entity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberClubServiceTest {

    @Autowired EntityManager entityManager;
    @Autowired MemberClubService memberClubService;

    @Test
    public void basicTest(){

        System.out.println("=========테스트 시작==============");
        List<MemberDto> result = memberClubService.findMemberClubs();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto.toString());

        }
        System.out.println("=========테스트 종료==============");
    }

}