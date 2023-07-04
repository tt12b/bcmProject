package ywluv.bcmProject.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import ywluv.bcmProject.dto.ClubDto;
import ywluv.bcmProject.dto.MemberDto;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberControllerTest {
    @Autowired MemberController memberController;

    @Test
    void memberRegister() {
        MemberDto memberDto = new MemberDto(
                1L
                ,   "닉네임"
                ,   "실명"
                ,   "1234"
                ,   null
                ,   null
        );

        memberController.memberRegister(memberDto);
    }
}