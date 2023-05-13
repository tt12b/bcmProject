package ywluv.bcmProject.repository.Deposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.DepositHistory;

@Repository
public interface DepositHistoryRepository extends JpaRepository<DepositHistory,Long> {


    @Query("SELECT SUM(dh.amount) FROM DepositHistory dh WHERE dh.member.id = :memberId")
    Long getTotalDepositOfMember(@Param("memberId") Long memberId);

    @Query("SELECT SUM(D.amount) FROM DepositHistory D WHERE D.amount <> 0")
    Long getTotalDeposit();
}
