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

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    private final MeetupService meetupService;


    @GetMapping("/meetup")
    public String meetupList(Model model){
        model.addAttribute("meetupList",meetupService.findAllMeetups(null));
        return "meetup/meetupList";

    }

    @PostMapping("/meetup")
    @ResponseBody
    public List<MeetupDto> meetupList(String initialDate){
       return meetupService.findAllMeetups(initialDate);

//       중복을 어떻게 처리 할 지 고민하기..
//1. 검색 시작일~ 종료일을 함께 전달하고, 배열에 저장한 후 그 이후, 이전 값 가져오기
//2. 이벤트 배열을 별도로 구분하고?..음..
    }




    @PostMapping("/meetupMake")
    @ResponseBody
    public MeetupDto meetupMake(@RequestBody MeetupDto meetupDto){

        Long meetupId = meetupService.makeMeetup(meetupDto);
        MeetupDto result = meetupService.findById(meetupId);

        return result;
    }
}
