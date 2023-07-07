package ywluv.bcmProject.controller.form;


import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import ywluv.bcmProject.dto.ClubDto;

import java.lang.annotation.*;
import java.util.List;

//클라이언트단에서 사용할 폼
//추후 상황에 따라 DTO로 통합 할지 고민해볼것,
//추후 벨리데이션 수정
@Getter
@Setter
public class MemberForm {

    @Length(max = 64, message ="최대 길이는 64자 이하입니다.") // 최대 길이 64
    @NotBlank(message = "닉네임은 필수입니다")
    private String userNickName;

    @NotBlank(message = "이름은 필수입니다")
    private String userName;

    @NotBlank(message = "패스워드는 필수입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자에서 16자 사이어야 합니다.")
    private String password;

    @PasswordMatch(message = "패스워드가 일치하지 않습니다.")
    private String passwordCheck;

    @NotBlank(message = "주소타입은 필수입니다")
    private String addressType;

    @NotBlank(message = "동호회 선택은 필수입니다.")
    private String clubType;


    public interface ValidationGroups {
        interface FirstValidation { }
        interface SecondValidation { }
    }



    @Target({ElementType.TYPE, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = PasswordMatchValidator.class)
    @Documented
    public @interface PasswordMatch {
        String message() default "패스워드가 일치하지 않습니다.";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

    public static class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, Object> {
        @Override
        public void initialize(PasswordMatch constraintAnnotation) {
        }

        @Override
        public boolean isValid(Object value, ConstraintValidatorContext context) {
            if (value instanceof MemberForm) {
                MemberForm form = (MemberForm) value;
                return form.getPassword() != null && form.getPassword().equals(form.getPasswordCheck());
            }
            return false;
        }
    }

}
