package observer.venda;

public class MonitoraCobrancas implements VendaObserver, DisplayElement{
	
	private VendaSubject caixa;
	private Cobranca cobranca;
	private float valorPago;
	
	public MonitoraCobrancas(VendaSubject caixa) {
		this.caixa = caixa;
		caixa.registerObserver(this);
	}	
	
	public void display() {
		float result = cobranca.getValor() - valorPago;
		if(result > 0) {
			System.out.println("Valor atual da cobran�a " + cobranca.getDescricao() + ":R$" + result);
			System.out.println("Gerar requisi��o de juros para pagamento da cobran�a: " + cobranca.getDescricao() + ". Valor pago: R$" + valorPago + ", valor faltante: R$" + (result*1.2) + ", com  juros de 20%");
			
		} else if(result < 0) {
			System.out.println("Valor atual da cobran�a " + cobranca.getDescricao() + ":R$0.0 , seu troco � de: R$" + (result * -1));
		} else {
			System.out.println("Valor atual da cobran�a " + cobranca.getDescricao() + ":R$" + result);
		}
	}

	@Override
	public void update(Cobranca cobranca, float valorPago) {
		this.cobranca = cobranca;
		this.valorPago = valorPago;
		display();
	}
}
