package observer.venda;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Relatorio rel = new Relatorio();
		rel.imprimeRelatorios(new ProdutosSupermercado().createIterator(), "PRODUTOS DO SUPERMERCADO");
		rel.imprimeRelatorios(new ProdutosCafeteria().createIterator(), "PRODUTOS DA CAFETERIA");
		
		System.out.println("------------------------------------------------");
		
		System.out.println("==========================OBSERVER=============================");
		Estoque estoque = new Estoque();
		EstoqueAtual estoqueAtual = new EstoqueAtual(estoque);
		Produto produto = new Produto("Feij�o", 4);
		estoque.setEstoque(produto, 10);
		estoque.setEstoque(produto, 5);
		estoque.setEstoque(produto, 1);
		
		
		System.out.println("==========================VENDA OBSERVER=============================");
		Caixa caixa = new Caixa();
		MonitoraCobrancas monitor = new MonitoraCobrancas(caixa);
		Cobranca cobranca = new Cobranca("Baconzitos de Morango ao Leite Manteigado com Nozes e Uva Passas Desnatadas", 50);
		caixa.setCobranca(cobranca, 1);
		caixa.setCobranca(cobranca, 5);
		caixa.setCobranca(cobranca, 50);
		caixa.setCobranca(cobranca, 75);
		caixa.setCobranca(cobranca, 9999);
	}
}
