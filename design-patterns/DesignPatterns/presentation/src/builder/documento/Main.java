package builder.documento;

public class Main {

    //esta é a classe Diretora
    protected static void construir(Builder builder, Documento doc) {
        //método construir, irá construir as partes do objeto complexo
        builder.buildTitulo(doc);
        builder.buildAutor(doc);
        builder.buildConteudo(doc);
    }

    public static void main(String[] args) {
        //1- Instanciar nossos TIPOS de construtora
        Builder docComumBuilder = new DocComumBuilder();
        Builder docHTMLBuilder = new DocHTMLBuilder();

        //2- Inicializar o objeto complexo, passando suas partes como parâmetro
        Documento doc = new Documento("Padrão Builder", "EU", "Escrevendo um builder de documentos!");

        //3- Construir o doc do primeiro tipo, sem formatação
        construir(docComumBuilder, doc);

        //4- Construir o doc do segundo tipo, com formatação
        construir(docHTMLBuilder, doc);

        //5- exibir os resultados;
        System.out.println(docComumBuilder.obterResultado());
        System.out.println(docHTMLBuilder.obterResultado());
    }
}
