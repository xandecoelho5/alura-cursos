package conta;

public class OrdemDeServicoAdapter implements Documento{

	OrdemDeServico os;
	
	public OrdemDeServicoAdapter(OrdemDeServico os) {
		this.os = os;
	}
	
	public void abreDocumento() {
		os.abreOS();
	}

	public void vendeItem() {
		os.vendeServico();
	}

	public void fazPagamento() {
		os.acertaOS();
	}

	public void fechaDocumento() {
		os.fechaOS();
	}
	
}
