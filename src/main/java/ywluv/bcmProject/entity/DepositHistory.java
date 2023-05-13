package ywluv.bcmProject.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedBy;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.entity.baseEntity.BaseEntityOnlyCreated;

/**
 * Deposit의 변경 이력을 저장하는 엔티티
 * 추후 트리거로 변경
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepositHistory extends BaseEntityOnlyCreated {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(updatable = false)
    private int amount;


    private String reason;

    private DepositHistory(Member member, int amount, String reason) {
        this.member = member;
        this.amount = amount;
        this.reason = reason;
    }

    public static DepositHistory createDepositHistory(Member member, int amount, String reason) {
        DepositHistory depositHistory = new DepositHistory(member, amount, reason);
        member.getDepositHistories().add(depositHistory);
        return depositHistory;
    }
}
