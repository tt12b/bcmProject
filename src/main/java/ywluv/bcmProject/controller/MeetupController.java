package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    @GetMapping("/meetup")
    public String meetupList(){

        return "meetup/meetupList";

    }
}
