package ywluv.bcmProject.controller.form;


import jakarta.validation.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;
import ywluv.bcmProject.dto.ClubDto;
import ywluv.bcmProject.dto.MemberDto;
import ywluv.bcmProject.entity.enumEntity.AddressType;
import ywluv.bcmProject.entity.enumEntity.ClubType;
import ywluv.bcmProject.validator.PasswordValidator;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static ywluv.bcmProject.validator.PasswordValidator.*;

//클라이언트단에서 사용할 폼
//추후 상황에 따라 DTO로 통합 할지 고민해볼것,
//추후 벨리데이션 수정

@Getter
@Setter
@ValidPassword
public class MemberForm {

    @Length(max = 64, message ="최대 길이는 64자 이하입니다.") // 최대 길이 64
    @NotBlank(message = "닉네임은 필수입니다")
    private String userNickName;

    @NotBlank(message = "이름은 필수입니다")
    private String userName;

    private String password;
    private String passwordCheck;

    @NotBlank(message = "주소타입은 필수입니다")
    private String addressType;

    @NotBlank(message = "동호회 선택은 필수입니다.")
    private String clubType;

    public MemberDto toDto(){
        //하드코딩 추후 변경
        List<ClubDto> clubDtos = new ArrayList<>();
        if(ClubType.valueOf(clubType).toString().equals("OBKKAndHRGR")){
            clubDtos.add(new ClubDto(ClubType.valueOf("OBKK").toString(),ClubType.valueOf("OBKK").getDisplayName()));
            clubDtos.add(new ClubDto(ClubType.valueOf("HRGR").toString(),ClubType.valueOf("HRGR").getDisplayName()));

        } else {
            clubDtos.add(new ClubDto(ClubType.valueOf(clubType).toString(),ClubType.valueOf(clubType).getDisplayName()));
        }

        MemberDto memberDto = new MemberDto(
                null
                , this.userNickName
                , this.userName
                , this.password
                , this.addressType
                , clubDtos
        );

        /**/


        return memberDto;
    }

}
