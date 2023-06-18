package com.vinicius.internetbanking.services;

import com.vinicius.internetbanking.entities.ExtratoCorrentista;
import com.vinicius.internetbanking.repositories.CorrentistaRepository;
import com.vinicius.internetbanking.repositories.ExtratoCorrentistaRepository;
import com.vinicius.internetbanking.services.exceptions.InvalidDepositException;
import com.vinicius.internetbanking.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ExtratoCorrentistaService {

    @Autowired
    private CorrentistaRepository correntistaRepository;

    @Autowired
    private ExtratoCorrentistaRepository extratoCorrentistaRepository;


    public ExtratoCorrentista depositarValor(Long id, Double valorDeposito) {
        ExtratoCorrentista obj = extratoCorrentistaRepository.findById(id).get();
        if (valorDeposito > 0) {
            obj.getCorrentista().setSaldo(obj.getCorrentista().getSaldo().
                    add(new BigDecimal(valorDeposito)));
            obj.setDescricao("Seu deposito foi realizado com sucesso!");
        } else {
            throw new InvalidDepositException("Não foi possível realizar o deposito");
        }

        obj.getCorrentista().setSaldo(obj.getCorrentista().getSaldo());
        return obj;
    }

    public ExtratoCorrentista sacarValor(Long id, Double value) {
        ExtratoCorrentista obj = extratoCorrentistaRepository.findById(id).get();

        if (value <= 100.0) {
            obj.setDescricao("Isento de Taxa de Saque");

        } else if (value > 100.00 && value <= 300.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getCorrentista().getSaldo(), 0.4);
            obj.getCorrentista().setSaldo(resultado);
            obj.setDescricao("Taxa de 0.4%");

        } else if (value > 300.0 && value <= 1500.0) {
            BigDecimal resultado = calcularDesconto(value, obj.getCorrentista().getSaldo(), 1);
            obj.getCorrentista().setSaldo(resultado);
            obj.setDescricao("Taxa de 1%");


        } else if (obj.getCorrentista().getIsPlanoExclusive().equals(true)) {
            obj.setDescricao("Isento de Taxa de Saque");

        } else {
            obj.setDescricao("O Seguinte Correntista Não Possui o Plano Exclusive!");
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
