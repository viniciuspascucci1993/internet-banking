package com.vinicius.internetbanking.tests;

import com.vinicius.internetbanking.dto.CorrentistaDTO;
import com.vinicius.internetbanking.entities.AccountHolder;
import com.vinicius.internetbanking.entities.ExtratoCorrentista;

import java.math.BigDecimal;
import java.util.Date;

public class Factory {

    public static AccountHolder createCorrentista() {
        AccountHolder correntista = new AccountHolder(
                1L, "Vinicius Torres Pascucci", true,
                BigDecimal.valueOf(14000.00), "19271-1", new Date()
        );
        return correntista;
    }

    public static CorrentistaDTO createCorrentistaDto() {

        AccountHolder correntista = createCorrentista();
        return new CorrentistaDTO(correntista);
    }

    public static ExtratoCorrentista createExtractAccountHolder() {
        ExtratoCorrentista extratoCorrentista =
                new ExtratoCorrentista(1L, createCorrentista(), "Teste de Extrato");
        return extratoCorrentista;
    }
}
