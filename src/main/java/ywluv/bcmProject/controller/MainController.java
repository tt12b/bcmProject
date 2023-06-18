package ywluv.bcmProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.service.MeetupService;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.util.DateUtil;

@Controller
public class MainController {
    @Autowired MemberClubService memberClubService;


    @GetMapping("/")
    public String main(Model model){

        return "main";

    }

    @GetMapping("/test")
    public String testController(Model model, MemberSearchCondition memberSearchCondition, Pageable pageable){
        pageable = PageRequest.of(0,1000,Sort.by(Sort.Order.asc("userNickName").ignoreCase()));

        Page<MemberDto> result = memberClubService.search(memberSearchCondition, pageable);
        model.addAttribute("memberInfo",result.getContent());
        model.addAttribute("memberInfoTotalPage",result.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "test";

    }
}
