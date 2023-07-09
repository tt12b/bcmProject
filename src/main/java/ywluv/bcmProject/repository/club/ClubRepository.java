package ywluv.bcmProject.repository.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Club;

@Repository
public interface ClubRepository extends JpaRepository<Club,String> {

}
