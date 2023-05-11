package ywluv.bcmProject.repository.memberclub;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.repository.member.MemberRepository;
import ywluv.dto.MemberDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberClubRepositoryImplTest {

    @Autowired EntityManager em;
    @Autowired MemberClubRepository memberClubRepository;

    @Test
    public void searchTest(){

        List<MemberDto> result = memberClubRepository.search();
        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }


    }
}