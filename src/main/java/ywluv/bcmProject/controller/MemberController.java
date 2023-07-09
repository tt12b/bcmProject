package ywluv.bcmProject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.DateUtils;
import ywluv.bcmProject.controller.form.MemberForm;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.ClubType;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.service.MemberService;
import ywluv.bcmProject.util.DateUtil;

import java.awt.*;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberClubService memberClubService;
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/myPage")
    public String myPage(){

        return "member/myPage";

    }


    @GetMapping("/memberRegister")
    public String memberRegisterPage(Model model){

        //밸리데이션 위해 멤버폼 클라이언트에 전달
        model.addAttribute("memberForm", new MemberForm());
        model.addAttribute("AddressType", AddressType.class);
        model.addAttribute("ClubType", ClubType.class);


        return "member/login/register";

    }

    @PostMapping("/memberRegister")
    public String memberRegister(@Valid MemberForm memberForm, BindingResult result, Model model){

        if (result.hasErrors()) {
            for (ObjectError error : result.getGlobalErrors()) {
                System.out.println(error.getArguments());
                System.out.println(error.getCode());
                System.out.println(error.getCodes());
                System.out.println(error.getDefaultMessage());
                System.out.println(error.getClass());

                String objectName = error.getObjectName();
                System.out.println("글로벌 에러의 이름: " + objectName);
            }
            return "member/login/register";
        }

        System.out.println("생성");
//        memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
//        memberService.createUser(memberDto);

        return "redirect:/";

    }
    @GetMapping("/memberList")
    public String memberList(Model model, MemberSearchCondition memberSearchCondition, Pageable pageable){

        //Datatables를 이용, 클라이언트 단에서 알아서 페이징 시키다.
//        if(pageable.getPageNumber()!=0){
//            pageable = PageRequest.of(pageable.getPageNumber()-1, pageable.getPageSize(),pageable.getSort());
//        }

            pageable = PageRequest.of(0,1000,Sort.by(Sort.Order.asc("userNickName").ignoreCase()));

            Page<MemberDto> result = memberClubService.search(memberSearchCondition, pageable);
            model.addAttribute("memberInfo",result.getContent());
            model.addAttribute("memberInfoTotalPage",result.getTotalPages());
            model.addAttribute("currentPage", pageable.getPageNumber());
            model.addAttribute("localDate", DateUtil.getCurrentDate());

        return "member/memberList";
    }
}
