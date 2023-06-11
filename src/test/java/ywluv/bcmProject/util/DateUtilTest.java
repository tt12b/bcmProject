package ywluv.bcmProject.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;


class DateUtilTest {

    @Autowired DateUtil dateUtil;

    @Test
    void basicTest(){
        String defaultDate = "2023-06-30";
        int startDate = -10;
        int endDate = 10;

        String result1 = dateUtil.manipulateDate(defaultDate, startDate);
        String result2 = dateUtil.manipulateDate(defaultDate, endDate);

        System.out.println(result1);
        System.out.println(result2);

    }

}