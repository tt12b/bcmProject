package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.MemberType;

import java.util.ArrayList;
import java.util.List;

@Entity
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

    private List<Club> club = new ArrayList<>();
}