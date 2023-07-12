package ywluv.bcmProject.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.util.DateUtils;
import ywluv.bcmProject.controller.form.MemberForm;
import ywluv.bcmProject.dto.MeetupDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.entity.Member;
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
    public String memberRegister(@Valid MemberForm memberForm, @NotNull BindingResult result, Model model, RedirectAttributes redirectAttributes){

        /*유효성 체크*/
        try{
            if (result.hasErrors()) {
                return "member/login/register";
            }

            MemberDto memberDto = memberForm.toDto();
            memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
            memberService.createUser(memberDto);
            // 성공 알림을 출력하기 위한 JavaScript 코드
            redirectAttributes.addFlashAttribute("message", "가입 성공");

            //추후 개발 회원 가입 후 세션 생성 후 저장할 것,(로그인 상태 유지)
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", e.getMessage());
            return "member/login/register";
        }


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
