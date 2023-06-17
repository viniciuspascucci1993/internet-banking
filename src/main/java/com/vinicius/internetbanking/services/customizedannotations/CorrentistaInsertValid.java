package com.vinicius.internetbanking.services.customizedannotations;

import com.vinicius.internetbanking.services.customizedannotations.impl.CorrentistaInsertValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Payload;

@Constraint(validatedBy = CorrentistaInsertValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CorrentistaInsertValid {

    String message() default "Validation error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
