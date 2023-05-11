package ywluv.bcmProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.repository.club.ClubRepository;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    ClubRepository clubRepository;

    public List<Club> findAllClub(){

        return clubRepository.findAll();
    }

}
