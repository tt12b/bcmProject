package ywluv.bcmProject.repository.Balance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.DepositHistory;

@Repository
public interface DepositHistoryRepository extends JpaRepository<DepositHistory,Long> {
}
