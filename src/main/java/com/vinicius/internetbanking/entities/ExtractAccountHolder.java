package com.vinicius.internetbanking.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_extract_account_holder")
public class ExtractAccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_extract_account_holder")
    private Long idExtractAccountHolder;
    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    private AccountHolder accountHolder;

    @OneToMany( mappedBy = "extractAccountHolder", cascade = CascadeType.ALL)
    private List<HistoricExtract> historicExtractList = new ArrayList<HistoricExtract>();
    private String description;

    public ExtractAccountHolder() { }

    public ExtractAccountHolder(Long idExtractAccountHolder, AccountHolder accountHolder, String description) {
        this.idExtractAccountHolder = idExtractAccountHolder;
        this.accountHolder = accountHolder;
        this.description = description;
    }

    public Long getIdExtractAccountHolder() {
        return idExtractAccountHolder;
    }

    public void setIdExtractAccountHolder(Long idExtractAccountHolder) {
        this.idExtractAccountHolder = idExtractAccountHolder;
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

    public List<HistoricExtract> getHistoricExtractList() {
        return historicExtractList;
    }

    public void setHistoricExtractList(List<HistoricExtract> historicExtractList) {
        this.historicExtractList = historicExtractList;
    }
}
