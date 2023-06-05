package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.MeetupType;
import ywluv.bcmProject.service.MemberService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"depositHistories","memberClubs"})
@Getter
public class Meetup extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="meetup_id")
    private Long id;

    private String meetupTitle;

    private LocalDateTime meetupStartDate;
    private LocalDateTime meetupEndDate;

    private String allDayYN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="meetupHosts")
    private Member meetupHost;

    @Enumerated(EnumType.STRING)
    private MeetupType meetupType;

    private String meetupMemo;

    @OneToMany(mappedBy = "meetup")
    private List<MeetupMember> meetupMembers = new ArrayList<>();

    public Meetup(Long id, String meetupTitle, LocalDateTime meetupStartDate, LocalDateTime meetupEndDate, String allDayYN, Member meetupHost, MeetupType meetupType, String meetupMemo, List<MeetupMember> meetupMembers) {
        this.id = id;
        this.meetupTitle = meetupTitle;
        this.meetupStartDate = meetupStartDate;
        this.meetupEndDate = meetupEndDate;
        this.allDayYN = allDayYN;
        this.meetupHost = meetupHost;
        this.meetupType = meetupType;
        this.meetupMemo = meetupMemo;
        this.meetupMembers = meetupMembers;
    }

    public MeetupDto toDto() {
        MeetupDto meetupDto = new MeetupDto();
        meetupDto.setGroupId(this.id);
        meetupDto.setMeetupTitle(this.meetupTitle);
        meetupDto.setStartDate(this.meetupStartDate);
        meetupDto.setAllDayYN(this.allDayYN);
        meetupDto.setEndDate(this.meetupEndDate);
        meetupDto.setMemo(this.meetupMemo);
        meetupDto.setMeetupType(this.meetupType.toString());
        meetupDto.setHostId(this.meetupHost.getId());
        meetupDto.setHostNickName(this.meetupHost.getUserName());
        return meetupDto;
    }



}
