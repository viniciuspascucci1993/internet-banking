package com.vinicius.internetbanking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.services.customizedannotations.CorrentistaInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CorrentistaInsertValid
public class AccountHolderDTO implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 5, max = 255, message = "The Field Must have in between 5 and 255 characters")
    @NotBlank(message = "Please Provide a valid Name!")
    private String name;

    @NotNull(message = "Exclusive Plan cannot be null")
    private Boolean exclusivePlan;
    @NotNull(message = "Please Provide a Ballance!")
    private BigDecimal ballance;
    @NotNull(message = "Please Provide a Account Number!")
    private String accountNumber;

    @NotNull(message = "Please provide a birth date!")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    public AccountHolderDTO(AccountHolder entitie) {
        this.id = entitie.getId();
        this.name = entitie.getName();
        this.exclusivePlan = entitie.getExclusivePlan();
        this.ballance = entitie.getBallance();
        this.accountNumber = entitie.getAccountNumber();
        this.birthDate = entitie.getBirthDate();
    }

}