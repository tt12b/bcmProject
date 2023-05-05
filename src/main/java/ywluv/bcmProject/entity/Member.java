package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.MemberType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString(of = {"id","userName","age","addressType","memberType"})
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String userName;
    private int age;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    @OneToMany(mappedBy = "member")
    private List<MemberClub> memberClubs = new ArrayList<>();
}