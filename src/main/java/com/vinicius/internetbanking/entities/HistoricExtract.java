package com.vinicius.internetbanking.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_historic_extract")
public class HistoricExtract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal futureReleasesAccount;
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

    public HistoricExtract() { }

    public HistoricExtract(Long id, BigDecimal futureReleasesAccount,
                           LocalDate dateFutureReleases,
                           LocalDate todaysDate, BigDecimal balanceDate,
                           BigDecimal bankInsurance, BigDecimal cellPhoneBill,
                           BigDecimal creditCard, BigDecimal severalBanking,
                           BigDecimal bankInterestReceived, BigDecimal othersTransfers,
                           BigDecimal bankLoan, BigDecimal fuel, BigDecimal ticket,
                           BigDecimal othersInvestments, BigDecimal otherTaxExpenses,
                           BigDecimal clothingAndAccessories) {
        this.id = id;
        this.futureReleasesAccount = futureReleasesAccount;
        this.dateFutureReleases = dateFutureReleases;
        this.todaysDate = todaysDate;
        this.balanceDate = balanceDate;
        this.bankInsurance = bankInsurance;
        this.cellPhoneBill = cellPhoneBill;
        this.creditCard = creditCard;
        this.severalBanking = severalBanking;
        this.bankInterestReceived = bankInterestReceived;
        this.othersTransfers = othersTransfers;
        this.bankLoan = bankLoan;
        this.fuel = fuel;
        this.ticket = ticket;
        this.othersInvestments = othersInvestments;
        this.otherTaxExpenses = otherTaxExpenses;
        this.clothingAndAccessories = clothingAndAccessories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getFutureReleasesAccount() {
        return futureReleasesAccount;
    }

    public void setFutureReleasesAccount(BigDecimal futureReleasesAccount) {
        this.futureReleasesAccount = futureReleasesAccount;
    }

    public LocalDate getDateFutureReleases() {
        return dateFutureReleases;
    }

    public void setDateFutureReleases(LocalDate dateFutureReleases) {
        this.dateFutureReleases = dateFutureReleases;
    }

    public LocalDate getTodaysDate() {
        return todaysDate;
    }

    public void setTodaysDate(LocalDate todaysDate) {
        this.todaysDate = todaysDate;
    }

    public BigDecimal getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(BigDecimal balanceDate) {
        this.balanceDate = balanceDate;
    }

    public BigDecimal getBankInsurance() {
        return bankInsurance;
    }

    public void setBankInsurance(BigDecimal bankInsurance) {
        this.bankInsurance = bankInsurance;
    }

    public BigDecimal getCellPhoneBill() {
        return cellPhoneBill;
    }

    public void setCellPhoneBill(BigDecimal cellPhoneBill) {
        this.cellPhoneBill = cellPhoneBill;
    }

    public BigDecimal getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(BigDecimal creditCard) {
        this.creditCard = creditCard;
    }

    public BigDecimal getSeveralBanking() {
        return severalBanking;
    }

    public void setSeveralBanking(BigDecimal severalBanking) {
        this.severalBanking = severalBanking;
    }

    public BigDecimal getBankInterestReceived() {
        return bankInterestReceived;
    }

    public void setBankInterestReceived(BigDecimal bankInterestReceived) {
        this.bankInterestReceived = bankInterestReceived;
    }

    public BigDecimal getOthersTransfers() {
        return othersTransfers;
    }

    public void setOthersTransfers(BigDecimal othersTransfers) {
        this.othersTransfers = othersTransfers;
    }

    public BigDecimal getBankLoan() {
        return bankLoan;
    }

    public void setBankLoan(BigDecimal bankLoan) {
        this.bankLoan = bankLoan;
    }

    public BigDecimal getFuel() {
        return fuel;
    }

    public void setFuel(BigDecimal fuel) {
        this.fuel = fuel;
    }

    public BigDecimal getTicket() {
        return ticket;
    }

    public void setTicket(BigDecimal ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getOthersInvestments() {
        return othersInvestments;
    }

    public void setOthersInvestments(BigDecimal othersInvestments) {
        this.othersInvestments = othersInvestments;
    }

    public BigDecimal getOtherTaxExpenses() {
        return otherTaxExpenses;
    }

    public void setOtherTaxExpenses(BigDecimal otherTaxExpenses) {
        this.otherTaxExpenses = otherTaxExpenses;
    }

    public BigDecimal getClothingAndAccessories() {
        return clothingAndAccessories;
    }

    public void setClothingAndAccessories(BigDecimal clothingAndAccessories) {
        this.clothingAndAccessories = clothingAndAccessories;
    }
}
