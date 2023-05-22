package ywluv.bcmProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.dto.MemberDto;

import java.util.List;

@Controller
public class MemberController {

    @Autowired MemberClubService memberClubService;

//    @GetMapping("/memberList")
//    public String home(Model model){
//        List<MemberDto> memberInfo = memberClubService.findMemberClubs();
//
//        model.addAttribute("memberInfo",memberInfo);
//
//        return "member/memberList";
//
//    }
    @GetMapping("/memberRegister")
    public String memberRegister(Model model){
        return "member/memberRegister";

    }

    @GetMapping("/memberList")
    public Page<MemberDto> search(@ModelAttribute MemberSearchCondition condition, Pageable pageable){

        return (Page<MemberDto>) memberClubService.search(condition,pageable);
    }


}
