package loja.orcamento;

import loja.DomainException;
import loja.http.HttpAdapter;

import java.util.Map;

public class RegistrarOrcamento {

    private HttpAdapter http;

    public RegistrarOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("orcamento nao finalizado");
        }

        String url = "http://api.externa/orcamento";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
        );
        http.post(url, dados);
    }
}
