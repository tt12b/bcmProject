package ywluv.bcmProject.service;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.util.List;

@SpringBootTest
@Transactional
class MemberClubServiceTest {

    @Autowired EntityManager entityManager;
    @Autowired MemberClubService memberClubService;

    @Test
    public void basicTest(){

        System.out.println("=========테스트 시작==============");
        // 테스트할 검색 조건 생성
        MemberSearchCondition condition = new MemberSearchCondition();
//        condition.setUserNickName("닉네임1");
//        condition.setUserName("이름1");
//        condition.setClubName("clubName");
//        condition.setDepositGoe(100);
//        condition.setDepositLoe(200);
//        condition.setAddressType(AddressType.OTHER);

        PageRequest pageable = PageRequest.of(0, 10);

        Page<MemberDto> result = memberClubService.search(condition, pageable);

        System.out.println(result.getSize());
        System.out.println(result);

        System.out.println("반복시작");
        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
        System.out.println("반복종료");



//
//
//        List<MemberDto> result = memberClubService.search();
//
//        for (MemberDto memberDto : result) {
//            System.out.println("memberDto = " + memberDto.toString());
//
//        }
        System.out.println("=========테스트 종료==============");
    }

}