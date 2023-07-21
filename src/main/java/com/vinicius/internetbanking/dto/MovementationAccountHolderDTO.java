package com.vinicius.internetbanking.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.internetbanking.entities.MovementationAccountHolder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementationAccountHolderDTO {

    private Long id;
    @Size(min = 5, max = 255, message = "The Field Must have in between 5 and 255 characters")
    @NotBlank(message = "Please Provide a valid Name!")
    private String nameAccountHolder;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String futureReleases;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFutureReleases;
    private LocalDate date;
    @NotNull(message = "Please Provide a valid Balance Date Account Holder!")
    private BigDecimal balanceDateAccountHolder;
    private String several;
    private String otherTransfers;
    private BigDecimal interestReceived;
    private String loans;
    private String ticket;
    private String creditCard;

    public MovementationAccountHolderDTO(MovementationAccountHolder entitie) {
        this.id = entitie.getId();
        this.nameAccountHolder = entitie.getNameAccountHolder();
        this.futureReleases = entitie.getFutureReleases();
        this.dateFutureReleases = entitie.getDateFutureReleases();
        this.date = entitie.getDate();
        this.balanceDateAccountHolder = entitie.getBalanceDateAccountHolder();
        this.several = entitie.getSeveral();
        this.otherTransfers = entitie.getOtherTransfers();
        this.interestReceived = entitie.getInterestReceived();
        this.loans = entitie.getLoans();
        this.ticket = entitie.getTicket();
        this.creditCard = entitie.getCreditCard();
    }
}
