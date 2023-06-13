package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.entity.Meetup;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.repository.meetup.MeetupRepository;
import ywluv.bcmProject.service.MeetupService;
import ywluv.bcmProject.service.MemberService;
import ywluv.bcmProject.util.DateUtil;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MeetupController {

    private final MeetupService meetupService;
    private final MemberService memberService;
    private final MeetupRepository meetupRepository;

    @GetMapping("/meetup")
    public String meetupList(Model model){
        model.addAttribute("meetupList",meetupService.findAllMeetups(null,null));
        return "meetup/meetupList";

    }

    /**
     * 이전 월, 다음 월 선택 시 일정을 가져온다.
     * 파라미터로 첫번째, 기준 월
     * 두번째 파라미터, 이미 존재하는 일정의 groupIdList
     * @return
     */
    @PostMapping("/meetup")
    @ResponseBody
    public List<MeetupDto> meetupList(    @RequestParam("initialDate") String initialDate,
                                          @RequestParam("groupIdList") String groupIdList)
    {

        //List<String>으로 받았더니 List 첫번째 값과 마지막 값에 대괄호가 붙은채로 넘어와서 문자열로 받음
        //String으로 넘겼더니 cast 오류 발생하여 Long타입으로 수정
        List<String> StringList = Arrays.asList(groupIdList.substring(1, groupIdList.length() - 1).split(","));
        List<Long> longList = new ArrayList<>();

        for (String str : StringList) {
            longList.add(Long.parseLong(str.trim()));
        }

       return meetupService.findAllMeetups(initialDate,longList);
    }



    @PostMapping("/meetupMake")
    @ResponseBody
    public MeetupDto meetupMake(@RequestBody MeetupDto meetupDto){

        Long meetupId = meetupService.makeMeetup(meetupDto);
        MeetupDto result = meetupService.findById(meetupId);

        return result;
    }
}
