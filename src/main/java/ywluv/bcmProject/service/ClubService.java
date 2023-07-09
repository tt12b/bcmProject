package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.enumEntity.ClubType;
import ywluv.bcmProject.repository.club.ClubRepository;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    public List<Club> findAllClub(){

        return clubRepository.findAll();
    }

    public Club findById(String clubId){

        return clubRepository.findById(clubId)
                .orElseThrow(() -> new IllegalArgumentException("클럽을 찾을 수 없습니다. :" + clubId));
    }

    public String createClub(Club club){

        clubRepository.save(club);
        return null;
    }

    /**
     * 모든 클럽 생성
     */
    public void createAllClub(){
        List<ClubType> clubTypes = Arrays.asList(ClubType.values());
        for (ClubType clubType : clubTypes) {

            if (clubType.toString().equals("OBKKAndHRGR")) {
                continue;
            }
            clubRepository.findById(clubType.toString()).orElseGet(() -> {
                return clubRepository.save(new Club(clubType.toString(), clubType.getDisplayName()));
            });
        }
    }


}
