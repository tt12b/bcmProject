package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","amount"})
public class Deposit {

    @Id @GeneratedValue
    @Column(name ="deposit_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "deposit")
    private Member member;

    private int amount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deposit")
    private List<DepositHistory> depositHistory = new ArrayList<>();

    public Deposit(Member member, int amount){
        this.member = member;
        this.amount = amount;
    }



}
