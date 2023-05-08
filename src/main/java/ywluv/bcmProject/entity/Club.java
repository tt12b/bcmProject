package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","teamName"})
public class Club extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="club_id")
    private Long id;
    private String clubName;

    @OneToMany(mappedBy = "club")
    private List<MemberClub> memberClubs = new ArrayList<>();

    public Club(String clubName) {
        this.clubName = clubName;
    }

    public void addMemberClub(MemberClub memberClub) {
        memberClubs.add(memberClub);
        memberClub.setClub(this);
    }

    public void removeMemberClub(MemberClub memberClub) {
        memberClubs.remove(memberClub);
        memberClub.setClub(null);
    }
}
