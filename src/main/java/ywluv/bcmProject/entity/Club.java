package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ywluv.bcmProject.dto.ClubDto;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","clubName"})
public class Club extends BaseEntity {

    @Id
    @Column(name="club_id")
    private String id;
    private String clubName;

    @OneToMany(mappedBy = "club")
    private final List<MemberClub> memberClubs = new ArrayList<>();

    public Club(String id, String clubName) {
        this.id = id;
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

    public ClubDto toDto(){
        return new ClubDto(id,clubName);
    }

}
