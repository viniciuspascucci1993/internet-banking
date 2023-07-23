package com.vinicius.internetbanking.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricExtractMessage {

    private Long id;
    private LocalDate futureReleasesAccount;
    private LocalDate dateFutureReleases;
    private LocalDate todaysDate;
    private BigDecimal balanceDate;
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
}
