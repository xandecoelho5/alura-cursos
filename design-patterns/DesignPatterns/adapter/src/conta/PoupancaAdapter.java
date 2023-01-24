package conta;

public class PoupancaAdapter implements Conta {

    ContaPoupanca poupanca;

    public PoupancaAdapter(ContaPoupanca poupanca) {
        this.poupanca = poupanca;
    }

    public void getSaldo() {
        poupanca.valorAcumulado();
    }
}
