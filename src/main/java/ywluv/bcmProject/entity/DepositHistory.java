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

    @Id
    private Long id;

    @Column(updatable = false)
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deposit_id")
    private Deposit deposit;

    private String reason;

    public DepositHistory(Deposit deposit, int amount, String reason){
        this.deposit = deposit;
        this.amount = amount;
        this.reason = reason;
    }

}
