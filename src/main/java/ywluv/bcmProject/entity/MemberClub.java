package ywluv.bcmProject.entity;

import jakarta.persistence.*;

//연결 테이블용 엔티티
@Entity
public class MemberClub {

    @Id @GeneratedValue
    @Column(name ="memberClub_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="club_id")
    private Club club;

    private Long MemberCount;

}
