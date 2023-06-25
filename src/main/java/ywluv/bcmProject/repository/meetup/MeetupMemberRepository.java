package ywluv.bcmProject.repository.meetup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ywluv.bcmProject.entity.MeetupMember;
import ywluv.bcmProject.entity.Member;

import java.util.List;

@Repository
public interface MeetupMemberRepository  extends JpaRepository<MeetupMember,Long> {

    List<MeetupMember> findByMemberId(Long id);

}
