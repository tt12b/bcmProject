package ywluv.bcmProject.apiController;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.service.MemberClubService;
import ywluv.bcmProject.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberClubService memberClubService;

    @GetMapping("/memberListAPI")
    public Page<MemberDto> memberListAPI(@ModelAttribute MemberSearchCondition condition, Pageable pageable){

        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getOffset());
        System.out.println(pageable.getPageNumber());
        return memberClubService.search(condition, pageable);
    }

    @GetMapping("/test")
    public Page<MemberDto> test(@ModelAttribute MemberSearchCondition condition, Pageable pageable){

        System.out.println("====================");
        System.out.println(pageable.getOffset());
        System.out.println("====================");
        System.out.println(pageable.getPageSize());
        return null;
//        return memberClubService.search(condition, pageable);
    }
}
