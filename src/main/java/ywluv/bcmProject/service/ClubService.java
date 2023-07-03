package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.repository.club.ClubRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    public List<Club> findAllClub(){

        return clubRepository.findAll();
    }

    public Club findById(Long clubId){

        return clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("회원을 찾을 수 없습니다. :" + clubId));
    }


}
