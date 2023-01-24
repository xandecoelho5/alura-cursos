package observer.venda;

import java.util.Arrays;

public class ProdutosCafeteria {
	
	private static final int MAX_PRODUTOS = 5;
	private int index = 0;
	private Produto[] lanches;
	
	public ProdutosCafeteria() {
		lanches = new Produto[MAX_PRODUTOS];
		addProduto("Caf�", 1.00);
		addProduto("P�o de Queijo", 2.00);
		addProduto("Sandu�che", 4.50);
		addProduto("Pastel�o", 2.50);
		addProduto("Bolo", 3.45);
		addProduto("kkkkkkkkkkkkkk", 3.45);
	}
	
	public void addProduto(String descricao, double preco) {	
		if (index < MAX_PRODUTOS) {
			lanches[index] = new Produto(descricao, preco);
			index++;
		}
	}

	public Produto[] getProdutos() {
		return lanches;
	}

	@Override
	public String toString() {
		return "ProdutosCafeteria [lanches=" + Arrays.toString(lanches) + "]";
	}	
	
	public Iterator createIterator() {
		return new CafeteriaIterator(lanches);
	}
}
