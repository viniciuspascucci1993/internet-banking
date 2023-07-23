package com.vinicius.internetbanking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.internetbanking.entities.HistoricExtract;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricExtractDTO {

    private Long id;
    private LocalDate futureReleasesAccount;
    private LocalDate dateFutureReleases;
    @NotNull(message = "Please provide a today's date!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate todaysDate;
    @NotNull(message = "Please Provide a Balance Date!")
    private BigDecimal balanceDate;
    @NotNull(message = "Please Provide a Bank Insurance!")
    private BigDecimal bankInsurance;
    private BigDecimal cellPhoneBill;
    private BigDecimal creditCard;
    private BigDecimal severalBanking;
    private BigDecimal bankInterestReceived;
    private BigDecimal othersTransfers;
    private BigDecimal bankLoan;
    private BigDecimal fuel;
    private BigDecimal ticket;
    private BigDecimal othersInvestments;
    private BigDecimal otherTaxExpenses;
    private BigDecimal clothingAndAccessories;

    public HistoricExtractDTO(HistoricExtract entitie) {
        this.id = entitie.getId();
        this.futureReleasesAccount = entitie.getFutureReleasesAccount();
        this.dateFutureReleases = entitie.getDateFutureReleases();
        this.todaysDate = entitie.getTodaysDate();
        this.balanceDate = entitie.getBalanceDate();
        this.bankInsurance = entitie.getBankInsurance();
        this.cellPhoneBill = entitie.getCellPhoneBill();
        this.creditCard = entitie.getCreditCard();
        this.severalBanking = entitie.getSeveralBanking();
        this.bankInterestReceived = entitie.getBankInterestReceived();
        this.othersTransfers = entitie.getOthersTransfers();
        this.bankLoan = entitie.getBankLoan();
        this.fuel = entitie.getFuel();
        this.ticket = entitie.getTicket();
        this.othersInvestments = entitie.getOthersInvestments();
        this.otherTaxExpenses = entitie.getOtherTaxExpenses();
        this.clothingAndAccessories = entitie.getClothingAndAccessories();

    }
}
