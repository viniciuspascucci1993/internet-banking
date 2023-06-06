package com.vinicius.internetbanking.application;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MethodApplication {

    public static void main(String[] args) {

        BigDecimal valorSaque = new BigDecimal(20);
        BigDecimal saldo = new BigDecimal(50);

        BigDecimal percentual =new BigDecimal(0);

        if(valorSaque.intValue()>=300) {
            percentual = saldo.divide(new BigDecimal(100)).multiply(new BigDecimal(1));
        }else {
            percentual = saldo.divide(new BigDecimal(100)).multiply(new BigDecimal(0.4));
        }

        percentual = percentual.setScale(2, RoundingMode.HALF_EVEN);

        System.out.println("O valor do impostoe é de "+percentual);

        BigDecimal resultado = valorSaque.add(percentual);
        System.out.println("O valor do saque + o impostoe é de "+resultado);

        resultado = saldo.subtract(resultado);
        System.out.println("O saldo após o saque é de "+resultado);

    }

    public static Double multiplicarValor(Double valor1, Double valor2, int precisaoMult) {

        valor1 = (valor1 == null ? 0D: valor1);
        valor2 = (valor2 == null ? 0D: valor2);
        precisaoMult = ( precisaoMult == 0 ? 4 : precisaoMult);

        // Transforma em BigDecimal e arredonda para baixo com 2 casas decimais.
        BigDecimal calculo = new BigDecimal(valor1.toString()).setScale(precisaoMult, RoundingMode.HALF_EVEN);
        BigDecimal valorAux = new BigDecimal(valor2.toString()).setScale(precisaoMult, RoundingMode.HALF_EVEN);

        // subtrai e atribui o produto no atributo
        calculo = calculo.multiply(valorAux);

        // atribui o resultado para 4 casas decimais
        calculo = calculo.setScale(precisaoMult, RoundingMode.FLOOR);

        // retorna o resultado convertendo-o para Double
        return new Double(calculo.toString());
    }

    public static Double calcularTaxa(){

        Double valorTaxaUmPorCento = 0.01;
        Double valorDoSaque = 20.0;
        Double valorSaldo = 50.0;

        Double somaTotalTaxas = valorSaldo * valorDoSaque;
        Double somaFinal = somaTotalTaxas - valorTaxaUmPorCento;

        return somaFinal;

    }
}
