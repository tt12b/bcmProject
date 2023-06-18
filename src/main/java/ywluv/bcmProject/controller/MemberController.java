package ywluv.bcmProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.DateUtils;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.util.DateUtil;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberClubService memberClubService;

    @GetMapping("/memberRegister")
    public String memberRegister(){

        return "member/memberRegister";

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
