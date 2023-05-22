package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class MemberController {

    private final MemberClubService memberClubService;

    @GetMapping("/memberRegister")
    public String memberRegister(){

        return "member/memberRegister";

    }
    @GetMapping("/memberList")
    public String memberList(Model model, @ModelAttribute MemberSearchCondition memberSearchCondition, Pageable pageable){

        System.out.println("오프셋");
        System.out.println(pageable.getOffset());
        System.out.println("리미트");
        Page<MemberDto> result = memberClubService.search(memberSearchCondition, pageable);

        model.addAttribute("memberInfo",result.getContent());
        model.addAttribute("memberInfoTotalPage",result.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        return "member/memberList";

    }



}
