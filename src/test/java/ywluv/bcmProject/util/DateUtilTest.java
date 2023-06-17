package ywluv.bcmProject.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static ywluv.bcmProject.util.DateUtil.StringToLocalDateTime;


class DateUtilTest {

    @Autowired DateUtil dateUtil;

    @Test
    void basicTest(){
        String defaultDate = "2023/06/30";

        System.out.println(StringToLocalDateTime(defaultDate));


    }


}