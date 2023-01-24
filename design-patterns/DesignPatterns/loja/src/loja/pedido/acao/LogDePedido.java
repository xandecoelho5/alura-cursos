package loja.pedido.acao;

import loja.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedido{

    @Override
    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: " + pedido);
    }
}
