package observer.venda;

import java.util.ArrayList;

public class Estoque implements Subject {

	private ArrayList observers;
	private Produto produto;
	private float qtdEstoque;
	
	public Estoque() {
		observers = new ArrayList();
		
	}
		
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	public void removeObserver(Observer observer) {
		int i = observers.indexOf(observer);
		if(i >= 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for(int i=0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(produto, qtdEstoque);
		}
	}
	
	public void estoqueAlterado() {
		notifyObservers();
	}
	
	public void setEstoque(Produto produto, float qteEstoque) {
		this.produto = produto;
		this.qtdEstoque = qteEstoque;
		estoqueAlterado();
	}
}
