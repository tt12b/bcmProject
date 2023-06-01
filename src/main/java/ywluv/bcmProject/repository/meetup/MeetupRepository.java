package ywluv.bcmProject.repository.meetup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup,Long> {
}
