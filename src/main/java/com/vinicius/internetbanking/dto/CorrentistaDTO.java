package com.vinicius.internetbanking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.services.customizedannotations.CorrentistaInsertValid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataNascimento;

    public CorrentistaDTO(AccountHolder entitie) {
        this.id = entitie.getId();
        this.nome = entitie.getNome();
        this.isPlanoExclusive = entitie.getIsPlanoExclusive();
        this.saldo = entitie.getSaldo();
        this.numeroConta = entitie.getNumeroConta();
        this.dataNascimento = entitie.getDataNascimento();
    }

}