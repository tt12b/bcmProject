package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.util.DateUtil;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    @GetMapping("/meetup")
    public String meetupList(Model model){
        model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "meetup/meetupList";

    }

    @PostMapping("/meetup")
    @ResponseBody
    public String meetupMake(@RequestBody MeetupDto meetupDto){
        System.out.println("=======================");
        System.out.println(meetupDto.toString());
        System.out.println("=======================");
        //수정 중
        return "결과";
    }
}
