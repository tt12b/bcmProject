package ywluv.bcmProject.config;

import com.p6spy.engine.spy.P6SpyOptions;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.*;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.ClubType;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.service.ClubService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static ywluv.bcmProject.entity.MemberClub.*;

@Profile("test")
@Component
@RequiredArgsConstructor
public class testInit {

    private final InitMember initMembers;
    private final InitMeetup initMeetup;

    //bean 초기화 시점에 실행
    @PostConstruct
    public void init() {
        //p6sy 커스텀
        P6SpyOptions.getActiveInstance().setLogMessageFormat(CustomP6spySqlFormat.class.getName());

        System.out.println("===PostContruct===");
        initMembers.createMembers();
        initMeetup.createMeetups();
        System.out.println("===PostContruct===");
    }

    // 스프링 라이플 사이클 특성상, @PostConstruct와 @Transactional 을 분리
    //테스트용 데이터 초기화 할 내부 클래스 생성
    @Component
    static class InitMember {
        @Autowired EntityManager em;
        //AuditorAware을 Bean으로 등록하게 되면 Auditor를 추출해     @CreatedBy/lastModifiedBy에 매핑
        @Autowired ClubService clubService;
        @Bean
        public AuditorAware<String> auditorProvider() {
            return () -> Optional.of("테스트");
        }
        @Transactional
        public void createMembers() {


            clubService.createAllClub();

            Club clubA = em.find(Club.class,ClubType.HRGR.toString());
            Club clubB = em.find(Club.class,ClubType.OBKK.toString());

            String createdBy = "테스트";
            int deposit = 0;
            AddressType addressType;
            Club selectedClub;
            for (int i = 1; i <= 100; i++) {
                Member member = new Member("닉네임 " +i, "이름"+i);
                if (i % 2 == 0) {
                    selectedClub = clubB;
                    addressType = AddressType.OBS;
                    deposit = 30;
                } else {
                    selectedClub = clubA;
                    addressType = AddressType.OTHER;
                    deposit = 20;
                }
                deposit = i*100;
                MemberClub memberClub = joinClub(member, selectedClub);
                member.changeAddressType(addressType);
                member.getMemberClubs().add(memberClub);
                member.updateDeposit(deposit);
                selectedClub.getMemberClubs().add(memberClub);
                em.persist(member);
                em.persist(memberClub);
            }

            em.persist(joinClub(em.find(Member.class,1L), em.find(Club.class, ClubType.HRGR.toString())));

        }
    }

    @Component
    static class InitMeetup {

        @Autowired EntityManager em;

        private static final String[] meetupTitles = {"배드민턴", "회식", "보드게임"};
        private static final MeetupType[] meetupTypes = {MeetupType.badminton, MeetupType.boardGame, MeetupType.overallGathering, MeetupType.partialGathering, MeetupType.walk, MeetupType.shopping, MeetupType.etc};
        private static final int MIN_MEMBER_ID = 1;
        private static final int MAX_MEMBER_ID = 100;
        private static final int MAX_MEETUP_DURATION = 7;
        private static final String DEFAULT_MEMO = "메모";

        @Transactional
        public void createMeetups() {
            for (int i = 0; i < 30; i++) {
                String meetupTitle = getRandomMeetupTitle();
                LocalDateTime meetupStartDate = getRandomDateTime();
                LocalDateTime meetupEndDate = getRandomEndDateTime(meetupStartDate);
                String allDayYN = "N";
                int meetupHostId = getRandomMemberId();
                MeetupType meetupType = getRandomMeetupType();
                String meetupMemo = DEFAULT_MEMO;
                List<MeetupMember> meetupMembers = new ArrayList<>();

                // Meetup 객체 생성
                Meetup meetup = new Meetup(
                         null
                        ,null
                        , meetupTitle
                        , meetupStartDate
                        , meetupEndDate
                        , allDayYN
                        , em.find(Member.class, meetupHostId)
                        , meetupType
                        , meetupMemo
                        , meetupMembers
                );

                // Meetup 객체를 영속화
                em.persist(meetup);
            }
        }


        private static String getRandomMeetupTitle() {
            Random random = new Random();
            int index = random.nextInt(meetupTitles.length);
            return meetupTitles[index];
        }

        private static LocalDateTime getRandomDateTime() {
            Random random = new Random();
            int year = 2023;
            int month = 6;
            int day = random.nextInt(30) + 1;
            int hour = random.nextInt(24);
            int minute = random.nextInt(60);
            int second = random.nextInt(60);
            return LocalDateTime.of(year, month, day, hour, minute, second);
        }

        private static LocalDateTime getRandomEndDateTime(LocalDateTime startDateTime) {
            Random random = new Random();
            int maxDuration = Math.max(Math.min(MAX_MEETUP_DURATION, 30 - startDateTime.getDayOfMonth()), 1);System.out.println(maxDuration);
            int duration = random.nextInt(maxDuration) + 1;
            System.out.println(duration);
            return startDateTime.plusDays(duration);
        }

        private static int getRandomMemberId() {
            Random random = new Random();
            return random.nextInt(MAX_MEMBER_ID - MIN_MEMBER_ID + 1) + MIN_MEMBER_ID;
        }

        private static MeetupType getRandomMeetupType() {
            Random random = new Random();
            int index = random.nextInt(meetupTypes.length);
            return meetupTypes[index];
        }

    }
}
