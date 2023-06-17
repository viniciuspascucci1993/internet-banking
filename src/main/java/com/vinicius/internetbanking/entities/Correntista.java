package com.vinicius.internetbanking.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_correntista")
public class Correntista implements Serializable {

    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "is_plano_exclusive")
    private Boolean isPlanoExclusive;
    private BigDecimal saldo;

    @Column(name = "numero_conta")
    private String numeroConta;
    @Column(name = "data_nascimento", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Date dataNascimento;

    public Correntista() { }

    public Correntista(Long id, String nome, Boolean isPlanoExclusive, BigDecimal saldo, String numeroConta, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.isPlanoExclusive = isPlanoExclusive;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getIsPlanoExclusive() {
        return isPlanoExclusive;
    }

    public void setIsPlanoExclusive(Boolean isPlanoExclusive) {
        this.isPlanoExclusive = isPlanoExclusive;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Correntista that = (Correntista) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
