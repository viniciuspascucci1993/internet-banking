package com.vinicius.internetbanking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_movement_account_holder")
public class MovementationAccountHolder {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_account_holder")
    private String nameAccountHolder;

    @Column(name = "future_releases")
    private String futureReleases;

    @Column(name = "date_future_releases")
    private LocalDate dateFutureReleases;
    private LocalDate date;

    @Column(name = "balance_account_holder")
    private BigDecimal balanceDateAccountHolder;
    private String several;

    @Column(name = "other_transfers")
    private String otherTransfers;

    @Column(name = "interest_received")
    private BigDecimal interestReceived;

    @Size(min = 5, max = 300)
    private String loans;

    @Size(min = 5, max = 300)
    private String ticket;

    @Size(min = 5, max = 300)
    @Column(name = "credit_card")
    private String creditCard;

    public MovementationAccountHolder() { }

    public MovementationAccountHolder(Long id, String nameAccountHolder,
                                      String futureReleases,
                                      LocalDate dateFutureReleases,
                                      LocalDate date,
                                      BigDecimal balanceDateAccountHolder,
                                      String several, String otherTransfers,
                                      BigDecimal interestReceived, String loans,
                                      String ticket, String creditCard) {
        this.id = id;
        this.nameAccountHolder = nameAccountHolder;
        this.futureReleases = futureReleases;
        this.dateFutureReleases = dateFutureReleases;
        this.date = date;
        this.balanceDateAccountHolder = balanceDateAccountHolder;
        this.several = several;
        this.otherTransfers = otherTransfers;
        this.interestReceived = interestReceived;
        this.loans = loans;
        this.ticket = ticket;
        this.creditCard = creditCard;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAccountHolder() {
        return nameAccountHolder;
    }

    public void setNameAccountHolder(String nameAccountHolder) {
        this.nameAccountHolder = nameAccountHolder;
    }

    public String getFutureReleases() {
        return futureReleases;
    }

    public void setFutureReleases(String futureReleases) {
        this.futureReleases = futureReleases;
    }

    public LocalDate getDateFutureReleases() {
        return dateFutureReleases;
    }

    public void setDateFutureReleases(LocalDate dateFutureReleases) {
        this.dateFutureReleases = dateFutureReleases;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getBalanceDateAccountHolder() {
        return balanceDateAccountHolder;
    }

    public void setBalanceDateAccountHolder(BigDecimal balanceDateAccountHolder) {
        this.balanceDateAccountHolder = balanceDateAccountHolder;
    }

    public String getSeveral() {
        return several;
    }

    public void setSeveral(String several) {
        this.several = several;
    }

    public String getOtherTransfers() {
        return otherTransfers;
    }

    public void setOtherTransfers(String otherTransfers) {
        this.otherTransfers = otherTransfers;
    }

    public BigDecimal getInterestReceived() {
        return interestReceived;
    }

    public void setInterestReceived(BigDecimal interestReceived) {
        this.interestReceived = interestReceived;
    }

    public String getLoans() {
        return loans;
    }

    public void setLoans(String loans) {
        this.loans = loans;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
