package ywluv.bcmProject.repository.memberclub;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.MemberClub;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberClubRepository extends JpaRepository<MemberClub,Long>, MemberClubRepositoryCustom{


}
