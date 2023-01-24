package facade.processo;

public class JusticeCivil implements Justice{
	
	public Processo getProcesso() {
		ProcessoCivil processoCivil = new ProcessoCivil();
		return processoCivil;
	}
}
