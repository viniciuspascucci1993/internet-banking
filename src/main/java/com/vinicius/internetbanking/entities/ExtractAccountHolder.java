package com.vinicius.internetbanking.entities;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_extract_account_holder")
public class ExtractAccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;
    private String description;

    public ExtractAccountHolder() { }

    public ExtractAccountHolder(Long id, AccountHolder accountHolder, String description) {
        this.id = id;
        this.accountHolder = accountHolder;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountHolder getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(AccountHolder accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
