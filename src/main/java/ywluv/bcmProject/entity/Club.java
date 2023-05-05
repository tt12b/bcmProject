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
    private String teamName;

    @OneToMany(mappedBy = "club")
    private List<MemberClub> memberClubs = new ArrayList<>();

//    public Team(String name) {
//        this.name = name;
//    }
}
