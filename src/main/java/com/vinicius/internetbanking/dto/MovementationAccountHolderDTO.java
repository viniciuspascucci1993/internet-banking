package com.vinicius.internetbanking.dto;


import com.vinicius.internetbanking.entities.MovementationAccountHolder;
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
    private String nameAccountHolder;
    private String futureReleases;
    private LocalDate dateFutureReleases;
    private LocalDate date;
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
