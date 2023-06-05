package com.vinicius.internetbanking.application;

import com.vinicius.internetbanking.dto.ContaDTO;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AgenciaBancariaApplication {

    static Scanner input = new Scanner(System.in);
    static ArrayList<ContaDTO> contasBancarias;


    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        operacoes();
    }

    public static void operacoes() {
        System.out.println("---------------------------------------------");
        System.out.println("---------------Bem Vindos a nossa Agência------------------------");
        System.out.println("----------------------------------------------");
        System.out.println("********** Selecione uma operação que deseja realizar ****************");
        System.out.println("|   Opção 1: Depositar um valor    |");
        System.out.println("|   Opção 2: Sacar um valor      |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                System.out.println("Obrigado por utilizar nossa agência");
                System.exit(0);
            default:
                System.out.println("Opção inválida");
                operacoes();
                break;
        }
    }

    public static ContaDTO encontrarConta(String numeroConta) {
        ContaDTO contaDTO = null;
        if (contasBancarias.size() > 0) {
            for (ContaDTO c : contasBancarias) {
                if (Objects.equals(c.getNumeroConta(), numeroConta)) {
                    contaDTO = c;
                }
            }
        }
        return contaDTO;
    }

    public static void depositar() {

        System.out.println("Favor Informar o numero da Conta:  ");
        int numeroConta = input.nextInt();

        ContaDTO contaDTO = encontrarConta(String.valueOf(numeroConta));

        if (contaDTO != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            contaDTO.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso! ");
        } else {
            System.out.println("Conta não encontrada ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Numero da Conta: ");
        int numeroConta = input.nextInt();

        ContaDTO contaDTO = encontrarConta(String.valueOf(numeroConta));

        if (contaDTO != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = input.nextDouble();
            contaDTO.sacarValor(valorSaque);
            System.out.println("Valor sacado com sucesso! ");
        } else {
            System.out.println("Conta não encontrada ");
        }
        operacoes();
    }
}
