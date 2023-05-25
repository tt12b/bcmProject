package ywluv.bcmProject.apiController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.MemberSearchCondition;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberApiControllerTest {

    @Autowired MemberApiController memberApiController;
    @Test
    public void basicTest(){
        MemberSearchCondition memberSearchCondition = new MemberSearchCondition();

        Pageable pageable = PageRequest.of(1,10);

        memberApiController.memberListAPI(memberSearchCondition,pageable);


    }
}