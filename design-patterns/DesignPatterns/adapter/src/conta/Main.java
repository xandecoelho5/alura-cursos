package conta;

public class Main {
	public static void main(String[] args) {
		Conta cc = new ContaCorrente();
		Conta cs = new ContaSalario();
		Conta cp = new PoupancaAdapter(new ContaPoupanca());
		
		cc.getSaldo();
		cs.getSaldo();
		cp.getSaldo();
		
		System.out.println("0-------------------DOCUMENTOS--------------------------0");
		Documento venda = new Venda();
		Documento os = new OrdemDeServicoAdapter(new OrdemDeServico());
		System.out.println("---------------------Vendas--------------------------");
		venda.abreDocumento();
		venda.vendeItem();
		venda.fazPagamento();
		venda.fechaDocumento();
		System.out.println("---------------------Ordens de Serviço----------------");
		os.abreDocumento();
		os.vendeItem();
		os.fazPagamento();
		os.fechaDocumento();	
	}
}
