package builder.documento;

//esta classe é derivada da construtora, epsecializando seus métodos
public class DocHTMLBuilder extends Builder {

    @Override
    public void buildTitulo(Documento doc) {
        resultado = "<html><head><title>" + doc.getTitulo() + "</title>"
                + "<meta charset= 'UTF-8>"
                + "<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
                + "</head><body><div align='center'> <p><font size='5'>"
                + "<strong>" + doc.getTitulo() + "</strong></font><br>";
    }

    @Override
    public void buildAutor(Documento doc) {
        resultado += "<strong>Autor: " + doc.getAutor() + "<br>";
    }

    @Override
    public void buildConteudo(Documento doc) {
        resultado += doc.getConteudo() + "</strong></p></div></body></html>";
    }
}
