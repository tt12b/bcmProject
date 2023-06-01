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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member meetupHost;

    @OneToMany(mappedBy = "meetup")
    private List<MeetupMember> meetupMembers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MeetupType meetupType;

    private String meetupMemo;

    public Meetup(String meetupTitle, LocalDateTime meetupStartDate, LocalDateTime meetupEndDate, Member meetupHost, List<MeetupMember> meetupMembers, MeetupType meetupType, String meetupMemo) {
        this.meetupTitle = meetupTitle;
        this.meetupStartDate = meetupStartDate;
        this.meetupEndDate = meetupEndDate;
        this.meetupHost = meetupHost;
        this.meetupMembers = meetupMembers;
        this.meetupType = meetupType;
        this.meetupMemo = meetupMemo;
    }



}
