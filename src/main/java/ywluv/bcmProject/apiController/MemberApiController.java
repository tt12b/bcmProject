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

        return memberClubService.search(condition, pageable);
    }
}
