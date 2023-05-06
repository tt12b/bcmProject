package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","userName","age","addressType","memberType"})
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String userName;
    private int age;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToMany(mappedBy = "member")
    private List<MemberClub> memberClubs = new ArrayList<>();

    public Member (String userName){
        this.userName=userName;
    }

    public Member (String userName, int age){
        this.userName=userName;
        this.age=age;
    }

    public Member (String userName, int age, MemberClub memberClub){
        this.userName=userName;
        this.age = age;
        addMemberClub(memberClub);
    }

    public void addMemberClub(MemberClub memberClub){
        memberClub.setMember(this);
        this.memberClubs.add(memberClub);
    }

    public void removeMemberClub(MemberClub memberClub) {
        memberClubs.remove(memberClub);
        memberClub.setMember(null);
    }

    public void removeAllClub(){
        this.getMemberClubs().clear();
    }



}