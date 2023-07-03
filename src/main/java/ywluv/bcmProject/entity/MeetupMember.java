package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

//연결 테이블용 엔티티
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"member", "meetup"})
public class MeetupMember extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "meetupMember_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetup_id")
    private Meetup meetup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            member.getMeetupMembers().add(this);
        }
    }

    public void setMeetup(Meetup meetup) {
        this.meetup = meetup;
        if (meetup != null) {
            meetup.getMeetupMembers().add(this);
        }
    }

    public static MeetupMember createMeetupMember(Member member, Meetup meetup){
        MeetupMember meetupMember = new MeetupMember();
        meetupMember.setMember(member);
        meetupMember.setMeetup(meetup);
        return meetupMember;
    }

}
