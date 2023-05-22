package ywluv.bcmProject.repository.memberclub;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;

import java.util.List;

public interface MemberClubRepositoryCustom {

    Page<MemberDto> searchMemberClubs(MemberSearchCondition memberSearchCondition, Pageable pageable);
}
