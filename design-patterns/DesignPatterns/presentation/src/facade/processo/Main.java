package facade.processo;

public class Main {

	public static void main(String[] args) {
		AdvogadoFacade advogado = new AdvogadoFacade();
		
		Processo processoCivil = advogado.getProcesso(AdvogadoFacade.CIVIL); 
		System.out.println("Civil: " + processoCivil.getDescricao());
		
		Processo processoCriminal = advogado.getProcesso(AdvogadoFacade.CRIMINAL);
		System.out.println("Criminal: " + processoCriminal.getDescricao());
	}

}
