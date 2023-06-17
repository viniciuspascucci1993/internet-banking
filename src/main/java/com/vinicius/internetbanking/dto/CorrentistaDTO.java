package com.vinicius.internetbanking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.internetbanking.entities.Correntista;
import com.vinicius.internetbanking.services.customizedannotations.CorrentistaInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@CorrentistaInsertValid
public class CorrentistaDTO implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 5, max = 255, message = "O campo deve estar entre 5 e 255 caracteres")
    @NotBlank(message = "Favor informar um nome!")
    private String nome;

    @NotNull(message = "Plano Exclusive não pode ser nulo!")
    private Boolean isPlanoExclusive;
    @NotNull(message = "Favor informar um salário!")
    private BigDecimal saldo;
    @NotNull(message = "Favor informar o numero da conta!")
    private String numeroConta;

    @NotNull(message = "Favor informar a data de aniversário!")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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