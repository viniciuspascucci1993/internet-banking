package com.vinicius.internetbanking.entities;



import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_account_holder")
public class AccountHolder implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "exclusive_plan")
    private Boolean exclusivePlan;
    private BigDecimal ballance;

    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "birth_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date birthDate;

    public AccountHolder() { }

    public AccountHolder(Long id, String name, Boolean exclusivePlan, BigDecimal ballance, String accountNumber, Date birthDate) {
        this.id = id;
        this.name = name;
        this.exclusivePlan = exclusivePlan;
        this.ballance = ballance;
        this.accountNumber = accountNumber;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getExclusivePlan() {
        return exclusivePlan;
    }

    public void setExclusivePlan(Boolean exclusivePlan) {
        this.exclusivePlan = exclusivePlan;
    }

    public BigDecimal getBallance() {
        return ballance;
    }

    public void setBallance(BigDecimal ballance) {
        this.ballance = ballance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountHolder that = (AccountHolder) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
