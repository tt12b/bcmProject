package ywluv.bcmProject.repository.memberclub;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import ywluv.bcmProject.entity.*;
import ywluv.dto.MemberDto;
import ywluv.dto.QMemberDto;

import java.util.List;

import static ywluv.bcmProject.entity.QClub.*;
import static ywluv.bcmProject.entity.QMember.*;
import static ywluv.bcmProject.entity.QMemberClub.memberClub;

public class MemberClubRepositoryImpl implements MemberClubRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public MemberClubRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<MemberDto> search() {

        return queryFactory
                .select(new QMemberDto(
                                member.userNickName
                                , member.userName
                                , member.addressType.stringValue()
                                , club.clubName.concat("/").as("clubNames")
                        )
                )
                .from(memberClub)
                .leftJoin(memberClub.member, member)
                .innerJoin(memberClub.club,club)
                .groupBy(member.id)
                .fetch();
    }
}
