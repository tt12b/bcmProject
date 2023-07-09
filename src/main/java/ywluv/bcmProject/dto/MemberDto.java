package ywluv.bcmProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import ywluv.bcmProject.entity.Club;
import ywluv.bcmProject.entity.Member;
import ywluv.bcmProject.entity.MemberClub;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.service.ClubService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static ywluv.bcmProject.entity.MemberClub.*;

@Data
@NoArgsConstructor
public class MemberDto {

    private Long memberId;
    private String userNickName;
    private String userName;
    private String password;
    private String addressType;
    private List<ClubDto> clubList;
    private int deposit;

    @QueryProjection
    public MemberDto(Long memberId,String userNickName, String userName, String password, String addressType,String clubList,int deposit) {
        this.memberId = memberId;
        this.userNickName = userNickName;
        this.userName = userName;
        this.password = password;
        this.addressType =addressType;
        this.clubList = clubList != null  ? Arrays.stream(clubList.split(","))
                    .map(str -> {
                                    String[] parts = str.split(":");
                                    String id = parts[0];
                                    String clubName = parts[1];
                                    return new ClubDto(id,clubName);
                                }
                        )
            .collect(Collectors.toList()):null;
        this.deposit = deposit;
    }

    public MemberDto(Long memberId,String userNickName, String userName, String password, String addressType,List<ClubDto> clubList) {
        this.memberId = memberId;
        this.userNickName = userNickName;
        this.userName = userName;
        this.password = password;
        this.addressType =addressType;
        this.clubList = clubList;
//        this.deposit = deposit;
    }
}

