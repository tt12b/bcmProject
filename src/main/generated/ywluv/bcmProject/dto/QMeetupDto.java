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

    public QMeetupDto(com.querydsl.core.types.Expression<Long> meetupId, com.querydsl.core.types.Expression<String> meetupTitle, com.querydsl.core.types.Expression<java.time.LocalDateTime> startDate, com.querydsl.core.types.Expression<java.time.LocalDateTime> endDate, com.querydsl.core.types.Expression<String> allDayY, com.querydsl.core.types.Expression<Long> hostId, com.querydsl.core.types.Expression<String> hostName, com.querydsl.core.types.Expression<String> meetupType, com.querydsl.core.types.Expression<String> memo) {
        super(MeetupDto.class, new Class<?>[]{long.class, String.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, String.class, long.class, String.class, String.class, String.class}, meetupId, meetupTitle, startDate, endDate, allDayY, hostId, hostName, meetupType, memo);
    }

}

