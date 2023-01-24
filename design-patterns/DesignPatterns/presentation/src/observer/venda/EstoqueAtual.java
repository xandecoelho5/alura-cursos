package observer.venda;

public class EstoqueAtual implements Observer, DisplayElement{

	private Subject estoque;
	private Produto produto;
	private float qtdEstoque;
	
	public EstoqueAtual(Subject estoque) {
		this.estoque = estoque;
		estoque.registerObserver(this);
	}	
	
	public void display() {
		System.out.println("Estoque atual do produto " + produto.getDescricao() + ":" + qtdEstoque);
		if(qtdEstoque < 2) {
			System.out.println("Gerar requisi��o de compra para o produto: " + produto.getDescricao());
		}
	}

	@Override
	public void update(Produto produto, float qtdEstoque) {
		this.produto = produto;
		this.qtdEstoque = qtdEstoque;
		display();
	}

}
