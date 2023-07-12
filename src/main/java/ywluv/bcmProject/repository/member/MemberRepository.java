package ywluv.bcmProject.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Member;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByUserName(String userName);

    int findDepositById(Long id);

    Optional<Member> findByUserNickName(String userNickName);
}
