package ywluv.bcmProject.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.dto.ResponseCookieDto;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.util.DateUtil;

@Controller
@Slf4j
public class LoginController {
    @Autowired MemberClubService memberClubService;

    @GetMapping("/")
    public String main(Model model){

        return "main";

    }

    @GetMapping("/login")
    public String login(){
        return "member/login/login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseCookieDto loginCheck(@AuthenticationPrincipal User user, HttpSession httpSession){
        String username = "empty";
        String session_id = "empty";

        if(user == null){
            log.info("user is null");
        } else {
            session_id = httpSession.getId();
            username = user.getUsername();
        }

        return new ResponseCookieDto(username, session_id);
    }


    @GetMapping("/test")
    @ResponseBody
    public String testController(Model model, MemberSearchCondition memberSearchCondition, Pageable pageable){
        pageable = PageRequest.of(0,1000,Sort.by(Sort.Order.asc("userNickName").ignoreCase()));

        Page<MemberDto> result = memberClubService.search(memberSearchCondition, pageable);
        model.addAttribute("memberInfo",result.getContent());
        model.addAttribute("memberInfoTotalPage",result.getTotalPages());
        model.addAttribute("currentPage", pageable.getPageNumber());
        model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "test";

    }
}
