package observer.venda;

public class Cobranca {

	private String descricao;
	private float valor;
	
	public Cobranca(String descricao, float valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public float getValor() {
		return valor;
	}	
}
