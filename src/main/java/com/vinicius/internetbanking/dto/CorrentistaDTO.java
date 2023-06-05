package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.Correntista;

import java.math.BigDecimal;
import java.util.Date;

public class CorrentistaDTO {

    private Long id;
    private String nome;
    private Boolean isPlanoExclusive;
    private BigDecimal saldo;
    private String numeroConta;
    private Date dataNascimento;

    public CorrentistaDTO() {
    }

    public CorrentistaDTO(Long id, String nome, Boolean isPlanoExclusive, BigDecimal saldo, String numeroConta,
                          Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.isPlanoExclusive = isPlanoExclusive;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.dataNascimento = dataNascimento;
    }

    public CorrentistaDTO(Correntista entitie) {
        this.id = entitie.getId();
        this.nome = entitie.getNome();
        this.isPlanoExclusive = entitie.getIsPlanoExclusive();
        this.saldo = entitie.getSaldo();
        this.numeroConta = entitie.getNumeroConta();
        this.dataNascimento = entitie.getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getIsPlanoExclusive() {
        return isPlanoExclusive;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}