package observer.venda;

import java.util.ArrayList;

public class ProdutosSupermercado {
	
	private ArrayList<Produto> produtosList;
	
	public ProdutosSupermercado() {
		produtosList = new ArrayList<Produto>();
		addProduto("Alface", 3.99);
		addProduto("Agri�o", 2.50);
		addProduto("Laranja", 2.80);
		addProduto("Ma��", 4.70);
		addProduto("Tomate", 6.75);
		addProduto("Bolo", 3.45);
	}
	
	public void addProduto(String descricao, double preco) {		
		produtosList.add(new Produto(descricao, preco));
	}
	
	public ArrayList<Produto> getProdutos(){
		return produtosList;
	}

	@Override
	public String toString() {
		return "ProdutosSupermercado [produtosList=" + produtosList + "]";
	}
	
	public Iterator createIterator() {
		return new SupermercadoIterator(produtosList);
	}
}
