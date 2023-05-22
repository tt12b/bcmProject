package ywluv.bcmProject.repository.memberclub;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MemberDto;

import java.util.List;

@SpringBootTest
@Transactional
class MemberClubRepositoryImplTest {

    @Autowired EntityManager em;
    @Autowired MemberClubRepository memberClubRepository;

    @Test
    public void searchTest(){




    }
}