package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.service.MeetupService;
import ywluv.bcmProject.service.MemberService;
import ywluv.bcmProject.util.DateUtil;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    private final MeetupService meetupService;


    @GetMapping("/meetup")
    public String meetupList(Model model){
        model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "meetup/meetupList";

    }

    @PostMapping("/meetup")
    @ResponseBody
    public Meetup meetupMake(@RequestBody MeetupDto meetupDto){
        System.out.println(meetupDto.toString());

        System.out.println("========");
        Long meetupId = meetupService.makeMeetup(meetupDto);
        System.out.println("========");
        Meetup meetup = meetupService.findById(meetupId);

        System.out.println("저장 완료");
        System.out.println(meetupId.toString());
        return meetup;
    }
}
