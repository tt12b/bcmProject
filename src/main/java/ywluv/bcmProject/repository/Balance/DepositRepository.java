package ywluv.bcmProject.repository.Balance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Deposit;
import ywluv.bcmProject.entity.DepositHistory;
import ywluv.bcmProject.entity.Member;

@Repository
public interface DepositRepository extends JpaRepository<Deposit,Long> {

    Deposit findByMember(Member member);
    Deposit findByMemberId(Long memberId);
}
