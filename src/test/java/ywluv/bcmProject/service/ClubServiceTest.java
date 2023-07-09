package ywluv.bcmProject.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.enumEntity.ClubType;
import ywluv.bcmProject.repository.club.ClubRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ClubServiceTest {

    @Autowired ClubService clubService;
    @Autowired ClubRepository clubRepository;

    @Test
    void test() {

        List<ClubType> clubTypes = Arrays.asList(ClubType.values());
        for (ClubType clubType : clubTypes) {
            clubRepository.findById(clubType.toString()).orElseGet(() -> {
                return clubRepository.save(new Club(clubType.toString(), clubType.getDisplayName()));
            });
        }


        List<Club> allClub = clubService.findAllClub();
        for (Club club : allClub) {
            System.out.println(club.getClubName());
        }
    }

}