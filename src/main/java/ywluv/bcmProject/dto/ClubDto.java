package ywluv.bcmProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClubDto {

    private String id;
    private String clubName;

    @QueryProjection
    public ClubDto(String id, String clubName) {
        this.id = id;
        this.clubName = clubName;
    }
}
