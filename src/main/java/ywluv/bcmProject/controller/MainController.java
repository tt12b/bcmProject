package ywluv.bcmProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;
import ywluv.bcmProject.service.MemberService;

import java.util.List;

@Controller
public class MainController {

    @Autowired MemberService memberService;

    @GetMapping("/")
    public String main(Model model){
        return "main";

    }

    @GetMapping("/memberList")
    public String home(Model model){
        List<Member> members = memberService.findMembers();

        model.addAttribute("members",members);
        for (Member member : members) {
            System.out.println("members = " + members);
        }

        return "member/memberList";

    }
}
