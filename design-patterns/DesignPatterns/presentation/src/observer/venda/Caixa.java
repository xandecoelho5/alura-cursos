package observer.venda;

import java.util.ArrayList;

public class Caixa implements VendaSubject{

	private ArrayList observers;
	private Cobranca cobranca;
	private float valorPago;
	
	public Caixa() {
		observers = new ArrayList();
	}
		
	public void registerObserver(VendaObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(VendaObserver observer) {
		int i = observers.indexOf(observer);
		if(i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for(int i=0; i < observers.size(); i++) {
			VendaObserver observer = (VendaObserver) observers.get(i);
			observer.update(cobranca, valorPago);
		}
	}
	
	public void valorRecebido() {
		notifyObservers();
	}
	
	public void setCobranca(Cobranca cobranca, float valorPago) {
		this.cobranca = cobranca;
		this.valorPago = valorPago;
		valorRecebido();
	}
}
