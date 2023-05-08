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

    private String userNickName;
    private String userName;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToMany(mappedBy = "member")
    private List<MemberClub> memberClubs = new ArrayList<>();

    public Member(String userNickName, String userName) {
        this.userNickName = userNickName;
        this.userName = userName;
    }

    public Member(String userNickName, String userName, AddressType addressType) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType = addressType;
    }
    public Member(String userNickName, String userName, AddressType addressType, MemberClub memberClub) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType = addressType;
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

    public void changeAddressType(AddressType addressType){
        this.addressType=addressType;
    }



}