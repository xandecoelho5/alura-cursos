package observer.venda;

public interface VendaSubject {
	public void registerObserver(VendaObserver observer);
	public void removeObserver(VendaObserver observer);
	public void notifyObservers(); 
}
