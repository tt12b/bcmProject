package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.bcmProject.repository.memberclub.MemberClubRepository;
import ywluv.dto.MemberDto;

import java.util.List;

@Service
@Transactional

public class MemberClubService {

    @Autowired MemberClubRepository memberClubRepository;

    public List<MemberDto> findMemberClubs(){

        return memberClubRepository.search();
    }

}
