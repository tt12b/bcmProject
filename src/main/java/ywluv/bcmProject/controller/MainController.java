package ywluv.bcmProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {



    @GetMapping("/")
    public String main(Model model){




        return "main";

    }

    @GetMapping("/defaultPage")
    public String defaultPager(Model model){
        return "defaultPage";

    }


}
