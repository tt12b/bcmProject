package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.bcmProject.repository.memberclub.MemberClubRepository;
import ywluv.bcmProject.dto.MemberDto;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberClubService {

    @Autowired MemberClubRepository memberClubRepository;

    public Page<MemberDto> search(MemberSearchCondition memberSearchCondition, Pageable pageable){

        return memberClubRepository.searchMemberClubs(memberSearchCondition,pageable);
    }

    @Transactional
    public void join(MemberClub memberClub){
        memberClubRepository.save(memberClub);
    }




}
