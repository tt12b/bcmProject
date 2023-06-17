package ywluv.bcmProject.repository.meetup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup,Long> {
    @Query("SELECT m FROM Member m WHERE m.id IN (:pks)")     // 2. Spring JPA In cause using @Query
    List<Member> findByTest(@Param("pks")List<Long> pks);

    @Query(
            "SELECT new ywluv.bcmProject.dto.MeetupDto(" +
            "                                   m.id" +
            "                               ,   m.groupId" +
            "                               ,   m.meetupTitle" +
            "                               ,   m.meetupStartDate" +
            "                               ,   m.meetupEndDate" +
            "                               ,   m.allDayYN" +
            "                               ,   m.meetupHost.id" +
            "                               ,   m.meetupHost.userNickName" +
            "                               ,   CAST(m.meetupType AS string)" +
            "                               ,   m.meetupMemo" +
            ") FROM Meetup m " +
            " WHERE :paramFrom <= m.meetupEndDate AND :paramTo >= m.meetupStartDate" +
            " AND m.id NOT IN (:groupIdList) " +
            " AND m.delete<>'Y'"
            )

        List<MeetupDto> findMeetupsByDateBetween(@Param("paramFrom") LocalDateTime paramFrom, @Param("paramTo") LocalDateTime paramTo
                                                 ,@Param("groupIdList") List<Long> groupIdList);

    @Query("SELECT m FROM Member m WHERE m.id IN (:ids)")
    List<Member> findByMembers(@Param("ids")List<Long> ids);
}
//" AND (:groupIdList IS NULL OR m.id NOT IN (:groupIdList))"