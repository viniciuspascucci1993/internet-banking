package com.vinicius.internetbanking.services.customizedannotations.impl;

import com.vinicius.internetbanking.controller.exceptions.FieldMessage;
import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.services.customizedannotations.CorrentistaInsertValid;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class CorrentistaInsertValidator implements ConstraintValidator<CorrentistaInsertValid, AccountHolderDTO>{


    @Override
    public void initialize(CorrentistaInsertValid ann) { }

    @Override
    public boolean isValid(AccountHolderDTO correntistaDTO, ConstraintValidatorContext context) {

        List<FieldMessage> fieldMessages = new ArrayList<>();

        for (FieldMessage e : fieldMessages) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldName()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return fieldMessages.isEmpty();
    }
}
