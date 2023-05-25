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

    private Long memberId;
    private String userNickName;
    private String userName;
    private String addressType;
    private String clubList;
    private int deposit;

    @QueryProjection
    public MemberDto(Long memberId,String userNickName, String userName, String addressType,String clubList,int deposit) {
        this.memberId = memberId;
        this.userNickName = userNickName;
        this.userName = userName;
        this.addressType =addressType;
        this.clubList = clubList;
        this.deposit = deposit;
    }
}
