package main.documento;

//esta é a classe construtora que possui os métodos de construção do nosso objeto complexo
public abstract class Builder {

    protected String resultado;

    //estes metodos sao responsaveis pela construção das partes do objeto complexo
    // cada um deles sera particularizado nas classes que formatam o documento da maneira correta
    public abstract void buildTitulo(Documento doc);

    public abstract void buildAutor(Documento doc);

    public abstract void buildConteudo(Documento doc);

    //metodo que exibe o resultado da construção, não necessitando de especialização
    public String obterResultado() {
        return resultado;
    }
}
