package ywluv.bcmProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeetupDto {

    private Long MeetupId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String eventTitle;
    private String memo;
    private String allDayYN;

    @QueryProjection
    public MeetupDto(LocalDateTime startDate, LocalDateTime endDate, String eventTitle, String memo, String allDayYN,Long meetupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventTitle = eventTitle;
        this.memo = memo;
        this.allDayYN = allDayYN;
        this.MeetupId = meetupId;
    }
}
