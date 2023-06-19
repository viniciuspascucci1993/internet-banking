package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.entities.ExtractAccountHolder;
import com.vinicius.internetbanking.repositories.AccountHolderRepository;
import com.vinicius.internetbanking.repositories.ExtractAccountHolderRepository;
import com.vinicius.internetbanking.services.exceptions.InvalidDepositException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExtratoCorrentistaService {

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private ExtractAccountHolderRepository extractAccountHolderRepository;


    public ExtractAccountHolder depositarValor(Long id, Double valorDeposito) {
        ExtractAccountHolder obj = extractAccountHolderRepository.findById(id).get();
        if (valorDeposito > 0) {
            obj.getAccountHolder().setBallance(obj.getAccountHolder().getBallance().
                    add(new BigDecimal(valorDeposito)));
            obj.setDescription("Seu deposito foi realizado com sucesso!");
        } else {
            throw new InvalidDepositException("Não foi possível realizar o deposito");
        }

        obj.getAccountHolder().setBallance(obj.getAccountHolder().getBallance());
        return obj;
    }

    public ExtractAccountHolder sacarValor(Long id, Double value) {
        ExtractAccountHolder obj = extractAccountHolderRepository.findById(id).get();

        if (value <= 100.0) {
            obj.setDescription("Isento de Taxa de Saque");

        } else if (value > 100.00 && value <= 300.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getAccountHolder().getBallance(), 0.4);
            obj.getAccountHolder().setBallance(resultado);
            obj.setDescription("Taxa de 0.4%");

        } else if (value > 300.0 && value <= 1500.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getAccountHolder().getBallance(), 1);
            obj.getAccountHolder().setBallance(resultado);
            obj.setDescription("Taxa de 1%");


        } else if (obj.getAccountHolder().getExclusivePlan().equals(true)) {
            obj.setDescription("Isento de Taxa de Saque");

        } else {
            obj.setDescription("O Seguinte Correntista Não Possui o Plano Exclusive!");
        }
        return obj;
    }

    private static BigDecimal calcularDesconto(double valorDeSaque, BigDecimal saldoConta, double percentualDesconto) {
        BigDecimal valorSaque = BigDecimal.valueOf(valorDeSaque);
        BigDecimal percentual = valorSaque.multiply(BigDecimal.valueOf(percentualDesconto));
        // valor de desconto
        BigDecimal valorDesconto = percentual.divide(new BigDecimal(100));
        valorDesconto = valorDesconto.setScale(2, RoundingMode.HALF_EVEN);
        valorDesconto = valorDesconto.add(valorSaque);

        BigDecimal resultado = saldoConta.subtract(valorDesconto);
        return resultado;
    }
}
