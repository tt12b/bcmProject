package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.*;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

//연결 테이블용 엔티티
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"member","club"})
public class MemberClub extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="memberClub_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
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

    public static MemberClub joinClub(Member member, Club club){
        MemberClub memberClub = new MemberClub();
        memberClub.setMember(member);
        memberClub.setClub(club);
        return memberClub;
    }

    public void withdrawMembership() {
        if (member != null) {
            member.getMemberClubs().remove(this);
            member = null;
        }

        if (club != null) {
            club.getMemberClubs().remove(this);
            club = null;
        }
    }

}
