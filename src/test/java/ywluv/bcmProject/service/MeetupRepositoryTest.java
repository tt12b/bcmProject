package ywluv.bcmProject.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.repository.meetup.MeetupRepository;
import ywluv.bcmProject.util.DateUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class MeetupRepositoryTest {
    
    @Autowired MeetupRepository meetupRepository;
    
    @Test
    void test(){
        java.util.List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        List<Member> employees = meetupRepository.findByMembers(ids);
        meetupRepository.findByMembers(ids);
    }

    @Test
    void test2(){
        java.util.List<Long> ids = new ArrayList<>();

        String initialDate = "2023-06-14";
        String from = DateUtil.manipulateDate(initialDate, -10);
        String to = DateUtil.manipulateDate(initialDate,+40);

        LocalDateTime paramFrom = LocalDateTime.parse(from+"T00:00:00");
        LocalDateTime paramTo = LocalDateTime.parse(to+"T00:00:00");


        String str = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]";
        str = str.replace("[", "").replace("]", ""); // 대괄호 제거
        String[] strArray = str.split(", "); // 문자열을 배열로 분할

        List<Long> longList = new ArrayList<>();
        for (String numStr : strArray) {
            longList.add(Long.parseLong(numStr.trim()));
        }

      List<Long> pks = new ArrayList<>();
        pks.add(1L);
        pks.add(2L);

        System.out.println(longList);
        System.out.println(pks);

//        meetupRepository.findMeetupsByDateBetween(paramFrom,paramTo,longList);
//        meetupRepository.findByTest(longList);

        Assertions.assertThat(0).isEqualTo(0);
    }
}
