package ywluv.bcmProject.repository.meetup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup,Long> {

//    @Query("SELECT new ywluv.bcmProject.dto.MeetupDto(m.id" +
//            "                               ,   m.meetupTitle" +
//            "                               ,   m.meetupStartDate" +
//            "                               ,   m.meetupEndDate" +
//            "                               ,   m.allDayYN" +
//            "                               ,   m.meetupHost.id" +
//            "                               ,   m.meetupHost.userNickName" +
//            "                               ,   m.meetupType" +
//            "                               ,   m.meetupMemo) FROM Meetup m WHERE :date BETWEEN m.meetupStartDate AND m.meetupEndDate")
@Query("SELECT new ywluv.bcmProject.dto.MeetupDto(m.id" +
        "                               ,   m.meetupTitle" +
        "                               ,   m.meetupStartDate" +
        "                               ,   m.meetupEndDate" +
        "                               ,   m.allDayYN" +
        "                               ,   m.meetupHost.id" +
        "                               ,   m.meetupHost.userNickName" +
        "                               ,   CAST(m.meetupType AS string)" +
        "                               ,   m.meetupMemo" +
        ") FROM Meetup m WHERE :date BETWEEN m.meetupStartDate AND m.meetupEndDate")

    List<Meetup> findMeetupsByDateBetween(@Param("date") LocalDateTime date);
}
