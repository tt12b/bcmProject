package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ywluv.bcmProject.util.DateUtil;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    @GetMapping("/meetup")
    public String meetupList(Model model){
        model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "meetup/meetupList";

    }
}
