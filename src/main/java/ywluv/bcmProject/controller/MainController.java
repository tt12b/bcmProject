package ywluv.bcmProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.service.MemberService;
import ywluv.dto.MemberDto;

import java.util.List;

@Controller
public class MainController {

    @Autowired MemberClubService memberClubService;


    @GetMapping("/")
    public String main(Model model){
        return "main";

    }

    @GetMapping("/memberList")
    public String home(Model model){
        List<MemberDto> memberInfo = memberClubService.findMemberClubs();

        model.addAttribute("memberInfo",memberInfo);

        return "member/memberList";

    }
}
