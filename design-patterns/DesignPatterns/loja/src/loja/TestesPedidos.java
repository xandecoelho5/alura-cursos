package loja;

import loja.pedido.GeraPedido;
import loja.pedido.GeraPedidoHandler;
import loja.pedido.acao.EnviarEmailPedido;
import loja.pedido.acao.LogDePedido;
import loja.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {
        String cliente = "Teste";
        BigDecimal valorOrcamento = new BigDecimal("300");
        int quantidadeItens = Integer.parseInt("2");

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(Arrays.asList(
                new SalvarPedidoNoBancoDeDados(),
                new EnviarEmailPedido(),
                new LogDePedido()));

        handler.executar(gerador);
    }
}
