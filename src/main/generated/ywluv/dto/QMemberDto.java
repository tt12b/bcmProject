package ywluv.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * ywluv.dto.QMemberDto is a Querydsl Projection type for MemberDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMemberDto extends ConstructorExpression<MemberDto> {

    private static final long serialVersionUID = -1725609993L;

    public QMemberDto(com.querydsl.core.types.Expression<String> userNickName, com.querydsl.core.types.Expression<String> userName, com.querydsl.core.types.Expression<String> addressType, com.querydsl.core.types.Expression<String> clubList) {
        super(MemberDto.class, new Class<?>[]{String.class, String.class, String.class, String.class}, userNickName, userName, addressType, clubList);
    }

}

