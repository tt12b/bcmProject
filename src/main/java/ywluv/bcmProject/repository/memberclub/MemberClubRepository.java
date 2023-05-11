package ywluv.bcmProject.repository.memberclub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.MemberClub;

@Repository
public interface MemberClubRepository extends JpaRepository<MemberClub,Long>, MemberClubRepositoryCustom{


}
