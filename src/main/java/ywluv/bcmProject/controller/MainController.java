package ywluv.bcmProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.baseEntity.BaseEntity;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model){

        return "main";

    }

    @GetMapping("/home")
    public String home(Model model){

        return "home";

    }
}
