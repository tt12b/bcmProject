package ywluv.bcmProject.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import ywluv.bcmProject.controller.form.MemberForm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static ywluv.bcmProject.validator.PasswordValidator.*;

public class PasswordValidator implements ConstraintValidator<ValidPassword,MemberForm>{


        @Override
        public void initialize(ValidPassword constraintAnnotation) {

        }

        @Override
        public boolean isValid(MemberForm memberForm,  ConstraintValidatorContext context) {
            String password = memberForm.getPassword();
            String passwordCheck = memberForm.getPasswordCheck();

            if (password == null || password.isEmpty()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("비밀번호는 필수입니다.").addConstraintViolation();
                return false;
            }

            if (password.length() < 8 || password.length() > 16) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("비밀번호는 8~16글자 사이어야 합니다.").addConstraintViolation();
                return false;
            }


            if (!password.equals(passwordCheck)) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate("비밀번호가 일치하지 않습니다.").addConstraintViolation();
                return false;
            }

            return true;
        }


    //@ValidPassword 어노테이션
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = PasswordValidator.class)
    public @interface ValidPassword {
        String message() default "Invalid password";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};

    }
}


