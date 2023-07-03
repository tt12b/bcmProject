package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"depositHistories","memberClubs","MeetupMembers","meetupHosts"})
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;

    private String userNickName;
    private String userName;

    private String password = "0000";
    private String role = "USER";

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    private int deposit = 0;
    @OneToMany(mappedBy = "member")
    private List<DepositHistory> depositHistories = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberClub> memberClubs = new ArrayList<>();

    @OneToMany(mappedBy = "meetupHost")
    private List<Meetup> meetupHosts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MeetupMember> MeetupMembers = new ArrayList<>();

    public Member(String userNickName, String userName) {
        this.userNickName = userNickName;
        this.userName = userName;
    }

    public Member(String userNickName, String userName, AddressType addressType) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType = addressType;
    }
    public Member(String userNickName, String userName, AddressType addressType, int deposit) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType = addressType;
        this.deposit = deposit;
    }

    public Member(String userNickName, String userName, AddressType addressType, int deposit, MemberClub memberClub) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType = addressType;
        this.deposit = deposit;
        addMemberClub(memberClub);
    }

    //회원가입용
    public Member(String userNickName, String userName, String password, AddressType addressType, int deposit, MemberClub memberClub) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.password = password;
        this.addressType = addressType;
        this.deposit = deposit;
        addMemberClub(memberClub);
    }

    public MemberDto toDto() {
        MemberDto memberDto = new MemberDto();

        memberDto.setMemberId(this.id);
        memberDto.setUserNickName(this.userNickName);
        memberDto.setUserName(this.userName);
        memberDto.setPassword(this.password);
        memberDto.setAddressType(this.addressType.toString());
        memberDto.setClubList(this.memberClubs.stream()
                .map(memberClub -> {
                    Club club = memberClub.getClub();
                    return "/" + club.getId() + ":" + club.getClubName();
                })
                .collect(Collectors.joining()));
        return memberDto;
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

    public void updateDeposit(int deposit){
        this.deposit=deposit;
    }



}