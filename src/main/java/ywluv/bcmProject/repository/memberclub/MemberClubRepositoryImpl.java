package ywluv.bcmProject.repository.memberclub;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.dto.MemberSearchCondition;
import ywluv.bcmProject.dto.QMemberDto;
import ywluv.bcmProject.entity.enumEntity.AddressType;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;
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
    public Page<MemberDto> searchMemberClubs(MemberSearchCondition condition, Pageable pageable) {

        List<MemberDto> result = queryFactory
                .select(new QMemberDto(
                                  member.id
                                , member.userNickName
                                , member.userName
                                , member.password
                                , member.addressType.stringValue()
                                , Expressions.stringTemplate(
                        "GROUP_CONCAT({0})",club.id.stringValue().concat(":").concat(club.clubName)
                                )
                                , member.deposit

                        )
                )
                .from(memberClub)
                .leftJoin(memberClub.member, member)
                .innerJoin(memberClub.club, club)
                .where(
                        userNickNameEq(condition.getUserNickName())
                        , userNameEq(condition.getUserName())
                        , clubNameEq(condition.getClubName())
                        , addressTypeEq(condition.getAddressType())
                        , depositGoe(condition.getDepositGoe())
                        , depositLoe(condition.getDepositLoe())
                )
                .groupBy(member.id)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(member.count())
                .from(member);


        return PageableExecutionUtils.getPage(result,pageable,countQuery::fetchOne);
    }


    private BooleanExpression userNickNameEq(String userNickName) {
        return hasText(userNickName) ? member.userNickName.eq(userNickName) : null;
    }

    private BooleanExpression userNameEq(String userName) {
        return hasText(userName) ? member.userName.eq(userName) : null ;
    }

    private BooleanExpression clubNameEq(String clubName) {
        return hasText(clubName) ? club.clubName.eq(clubName) : null ;
    }

    private BooleanExpression addressTypeEq(AddressType addressType) {
        return (addressType != null) ? member.addressType.eq(addressType) : null;
    }

    private BooleanExpression depositGoe(Integer depositGoe) {
        return depositGoe != null ? member.deposit.goe(depositGoe) : null;
    }

    private BooleanExpression depositLoe(Integer depositLoe) {
        return depositLoe != null ? member.deposit.loe(depositLoe) : null;
    }


    private BooleanExpression ageBetween(int depositLoe, int depositGoe) {
        return depositGoe(depositGoe).and(depositLoe(depositLoe));
    }
}
