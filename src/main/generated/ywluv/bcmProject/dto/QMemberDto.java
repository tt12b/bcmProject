package ywluv.bcmProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * ywluv.bcmProject.dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = 1105417556L;

    public QMemberDto(com.querydsl.core.types.Expression<Long> memberId, com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> password, com.querydsl.core.types.Expression<String> addressType, com.querydsl.core.types.Expression<String> clubList, com.querydsl.core.types.Expression<Integer> deposit) {
        super(MemberDto.class, new Class<?>[]{long.class, String.class, String.class, String.class, String.class, String.class, int.class}, memberId, userNickName, userName, password, addressType, clubList, deposit);
    }

}

