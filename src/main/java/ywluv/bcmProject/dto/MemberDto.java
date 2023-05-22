package ywluv.bcmProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;
import ywluv.bcmProject.entity.Club;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@ToString
public class MemberDto {

    private String userNickName;
    private String userName;
    private String addressType;
    private String clubList;

    @QueryProjection
    public MemberDto(String userNickName, String userName, String addressType,String clubList) {
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType =addressType;
        this.clubList = clubList;
    }
}
