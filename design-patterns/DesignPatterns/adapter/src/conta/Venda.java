package conta;

public class Venda implements Documento{

	public void abreDocumento() {
		System.out.println("Abre Documento de Venda");
	}

	public void vendeItem() {
		System.out.println("Venda de um item de venda");
	}

	public void fazPagamento() {
		System.out.println("Faz pagamento de Venda");
	}

	public void fechaDocumento() {
		System.out.println("Fecha Documento de Venda");
	}

}
