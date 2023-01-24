package observer.venda;

import java.util.ArrayList;

public class SupermercadoIterator implements Iterator{
	
	private ArrayList<Produto> produto;
	private int index = 0;
	
	public SupermercadoIterator(ArrayList<Produto> produtos) {
		this.produto = produtos;
	}
	
	public boolean hasNext() {
		return index < produto.size() && produto.get(index) != null;
	}
	
	public Object next() {
		return produto.get(index++);
	}
	
}
