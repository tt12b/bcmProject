package ywluv.bcmProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.Querydsl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.repository.member.MemberRepository;
import ywluv.bcmProject.service.MemberService;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor  // @RequestBody를 사용할 객체는 필드를 바인딩할 생성자나 setter 메서드가 필요없다.
//다만 직렬화를 위해 기본 생성자는 필수다.
public class MeetupDto {

    private Long id;
    private Long groupId;
    private String meetupTitle;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String allDayYN;
    private Long hostId;
    private String HostNickName;
    private String meetupType;
    private String memo;

    public MeetupDto(Long id,Long groupId, String meetupTitle, LocalDateTime startDate, LocalDateTime endDate, String allDayYN,   Long hostId, String HostNickName) {
        this.id = id;
        this.groupId = groupId;
        this.meetupTitle = meetupTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allDayYN = allDayYN;
        this.hostId = hostId;
        this.HostNickName = HostNickName;
    }

    @QueryProjection
    public MeetupDto(Long id, Long groupId, String meetupTitle, LocalDateTime startDate, LocalDateTime endDate
            ,   String allDayYN
            ,   Long hostId, String HostNickName
            ,   String meetupType
            ,   String memo)
    {
        this.id = id;
        this.groupId = groupId;
        this.meetupTitle = meetupTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.allDayYN = allDayYN;
        this.hostId = hostId;
        this.HostNickName = HostNickName;
        this.meetupType = meetupType;
        this.memo = memo;
    }
}
