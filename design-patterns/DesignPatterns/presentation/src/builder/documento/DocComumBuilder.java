package builder.documento;

//esta classe é derivada da construtora, epsecializando seus métodos
public class DocComumBuilder extends Builder {

    @Override
    public void buildTitulo(Documento doc) {
        resultado = doc.getTitulo() + "\n";
    }

    @Override
    public void buildAutor(Documento doc) {
        resultado += doc.getAutor() + "\n";
    }

    @Override
    public void buildConteudo(Documento doc) {
        resultado += doc.getConteudo() + "\n";
    }

}
