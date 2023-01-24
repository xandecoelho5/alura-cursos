package loja;

import loja.imposto.CalculadoraDeImpostos;
import loja.imposto.ICMS;
import loja.imposto.ISS;
import loja.orcamento.ItemOrcamento;
import loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesImpostos {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();

        System.out.println(calculadora.calcular(orcamento, new ICMS(null)));
        System.out.println(calculadora.calcular(orcamento, new ISS(null)));
        System.out.println(calculadora.calcular(orcamento, new ICMS(new ISS(null))));
    }
}
