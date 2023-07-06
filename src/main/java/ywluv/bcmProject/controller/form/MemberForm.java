package ywluv.bcmProject.controller.form;


import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import ywluv.bcmProject.dto.ClubDto;

import java.util.List;

//클라이언트단에서 사용할 폼
//추후 상황에 따라 DTO로 통합 할지 고민해볼것,
@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "닉네임은 필수입니다")
    private String userNickName;

    @NotEmpty(message = "이름은 필수입니다")
    private String userName;

    @NotEmpty(message = "패스워드는 필수입니다")
    private String password;

    @NotEmpty(message = "주소타입은 필수입니다")
    private String addressType;

    @NotEmpty(message = "동호회 선택은 필수입니다.")
    private String clubType;

}
