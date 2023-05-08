package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.*;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

//연결 테이블용 엔티티
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MemberClub extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="memberClub_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    public void setMember(Member member) {
        this.member = member;
        if (member != null) {
            member.getMemberClubs().add(this);
        }
    }

    public void setClub(Club club) {
        this.club = club;
        if (club != null) {
            club.getMemberClubs().add(this);
        }
    }

    public MemberClub(Member member, Club club){
        this.member = member;
        this.club = club;
    }
}
