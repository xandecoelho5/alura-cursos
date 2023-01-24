package facade.processo;

public class AdvogadoFacade {
	
	public static final int CRIMINAL = 0;
	public static final int CIVIL = 1;
	
	public Processo getProcesso(int tipo) {
		switch (tipo) {
		case CRIMINAL:
			Justice justiceCriminal = new JusticeCriminal(); 
			return justiceCriminal.getProcesso();
		case CIVIL:
			Justice justiceCivil = new JusticeCivil(); 
			return justiceCivil.getProcesso();
		default:
			return null;
		}
	}
}
