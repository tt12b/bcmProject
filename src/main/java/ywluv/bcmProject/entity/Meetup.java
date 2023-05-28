package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.MeetupType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Meetup extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="meetup_id")
    private Long id;

    private String meetupName;

    private LocalDateTime meetupDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member meetingHost;

    @OneToMany(mappedBy = "meetup")
    private List<MeetupMember> meetupMembers = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private MeetupType meetupType;

    private String meetupNotes;


}
