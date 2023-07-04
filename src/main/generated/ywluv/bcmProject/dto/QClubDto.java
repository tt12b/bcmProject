package ywluv.bcmProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * ywluv.bcmProject.dto.QClubDto is a Querydsl Projection type for ClubDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QClubDto extends ConstructorExpression<ClubDto> {

    private static final long serialVersionUID = -85129864L;

    public QClubDto(com.querydsl.core.types.Expression<Long> id, com.querydsl.core.types.Expression<String> clubName) {
        super(ClubDto.class, new Class<?>[]{long.class, String.class}, id, clubName);
    }

}

