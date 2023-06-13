package ywluv.bcmProject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MeetupDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MeetupServiceTest {

    @Autowired MeetupService meetupService;
    @Test
    void findAllMeetupsInMonth() {
        String yearMonth = "2023-06-07";
        List<MeetupDto> allMeetupsInMonth = meetupService.findAllMeetups(yearMonth,null);

        System.out.println("=====================");
        System.out.println(allMeetupsInMonth);

        for (MeetupDto meetupDto : allMeetupsInMonth) {
            System.out.println(meetupDto);
        }
    }


}