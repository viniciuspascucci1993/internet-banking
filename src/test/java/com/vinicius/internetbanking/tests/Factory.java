package com.vinicius.internetbanking.tests;

import com.vinicius.internetbanking.dto.AccountHolderDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.entities.ExtractAccountHolder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Factory {

    public static AccountHolder createCorrentista() {
        return new AccountHolder(
                1L, "Vinicius Torres Pascucci", true,
                BigDecimal.valueOf(14000.00), "19271-1", new Date()
        );
    }

    public static AccountHolderDTO createCorrentistaDto() {

        AccountHolder correntista = createCorrentista();
        return new AccountHolderDTO(correntista);
    }

    public static ExtractAccountHolder createExtractAccountHolder() {
        return new ExtractAccountHolder(1L, createCorrentista(), "Teste de Extrato");
    }
}
