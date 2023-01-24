package builder.documento;

//Produto = objeto complexo a ser construído
public class Documento {

    private String titulo;
    private String autor;
    private String conteudo;

    public Documento(String titulo, String autor, String conteudo) {
        this.titulo = titulo;
        this.autor = autor;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getConteudo() {
        return conteudo;
    }
}
