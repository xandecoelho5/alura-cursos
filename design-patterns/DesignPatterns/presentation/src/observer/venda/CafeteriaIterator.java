package observer.venda;

public class CafeteriaIterator implements Iterator {

	private Produto[] produto;
	private int index;
	
	public CafeteriaIterator(Produto[] produtos) {
		this.produto = produtos;
	}
	
	public boolean hasNext() {
		return index < produto.length && produto[index] != null;
	}

	public Object next() {
		return produto[index++];
	}

}
