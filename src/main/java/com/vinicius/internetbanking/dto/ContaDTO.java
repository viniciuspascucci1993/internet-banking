package com.vinicius.internetbanking.dto;

import com.vinicius.internetbanking.entities.Correntista;

import java.math.BigDecimal;

public class ContaDTO {

    public static int contadorContas = 1;

    private String numeroConta;
    private Correntista correntista;
    private BigDecimal saldo = new BigDecimal("0.0");

    public ContaDTO(Correntista correntista) {
        this.numeroConta = String.valueOf(contadorContas);
        this.correntista = correntista;
        contadorContas += 1;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo().add(BigDecimal.valueOf(valor)));
            System.out.println("Seu deposito foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar o deposito!");
        }
    }

    public void sacarValor(Double valor) {

        BigDecimal taxaQuatroPorCento
                = new BigDecimal("0.4");

        BigDecimal taxaUmPorCento
                = new BigDecimal("1");
        if (valor <= 100.0) {
            System.out.println("Isento de Taxa de saque!");
        } if (valor > 100.0 && valor >= 300.0) {
            setSaldo(getSaldo().subtract(taxaQuatroPorCento));
            System.out.println("Saque realizado com sucesso!" + valor);
        } if (valor > 300.0) {
            setSaldo(getSaldo().subtract(taxaUmPorCento));
            System.out.println("Saque relizado com sucesso!" + valor);
        } if (correntista.getIsPlanoExclusive()) {
            System.out.println("Isento de Taxa de saque!");
        } else {
            System.out.println("Houve um problema ao efetuar o saque!");
        }
    }
}
