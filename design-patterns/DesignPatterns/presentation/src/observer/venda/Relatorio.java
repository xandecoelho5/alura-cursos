package observer.venda;

public class Relatorio {
	
	public void imprimeRelatorios(Iterator iterator, String descricao) {
		System.out.println("==================" + descricao + "===================");
		while(iterator.hasNext()) {
			Produto produto = (Produto)iterator.next();
			System.out.println("Produto: " + produto.getDescricao() + ": " + produto.getPreco());
		}
	}
}
