package facade.processo;

public class JusticeCriminal implements Justice{
	
	@Override
	public Processo getProcesso() {
		return new ProcessoCriminal();
	}
}
