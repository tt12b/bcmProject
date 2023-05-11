package ywluv.bcmProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/memberRegister")
    public String memberRegister(Model model){


        return "member/memberRegister";

    }
}
