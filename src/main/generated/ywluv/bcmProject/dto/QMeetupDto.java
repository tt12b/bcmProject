package ywluv.bcmProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * ywluv.bcmProject.dto.QMeetupDto is a Querydsl Projection type for MeetupDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QMeetupDto extends ConstructorExpression<MeetupDto> {

    private static final long serialVersionUID = -1169603124L;

    public QMeetupDto(com.querydsl.core.types.Expression<java.time.LocalDateTime> startDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> endDate, com.querydsl.core.types.Expression<String> eventTitle, com.querydsl.core.types.Expression<String> memo, com.querydsl.core.types.Expression<String> allDayYN, com.querydsl.core.types.Expression<Long> meetupId) {
        super(MeetupDto.class, new Class<?>[]{java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, String.class, String.class, long.class}, startDate, endDate, eventTitle, memo, allDayYN, meetupId);
    }

}

