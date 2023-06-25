package ywluv.bcmProject.repository.meetup;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.MeetupMember;
import ywluv.bcmProject.service.MeetupService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class MeetupMemberRepositoryTest {

    @Autowired MeetupMemberRepository meetupMemberRepository;
    @Autowired MeetupService meetupService;
    @Test
    void basicTest(){


        //1번 2번 3번 회원을 추가
        meetupService.saveMeetupMembers(1L,"1/2/3");

        meetupService.saveMeetupMembers(1L,"1/2/3/4");


    }
}