package com.vinicius.internetbanking.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_extrato_correntista")
public class ExtratoCorrentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "correntista_id")
    private Correntista correntista;
    private String descricao;

    public ExtratoCorrentista() { }

    public ExtratoCorrentista(Long id, Correntista correntista, String descricao) {
        this.id = id;
        this.correntista = correntista;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            correntista.setSaldo(correntista.getSaldo().add(BigDecimal.valueOf(valor)));
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
            correntista.setSaldo(correntista.getSaldo().subtract(taxaQuatroPorCento));
            System.out.println("Saque realizado com sucesso!" + valor);
        } if (valor > 300.0) {
            correntista.setSaldo(correntista.getSaldo().subtract(taxaUmPorCento));
            System.out.println("Saque relizado com sucesso!" + valor);
        } if (correntista.getIsPlanoExclusive()) {
            System.out.println("Isento de Taxa de saque!");
        } else {
            System.out.println("Houve um problema ao efetuar o saque!");
        }
    }
}
