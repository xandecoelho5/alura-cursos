package ed.vetor;

public class Aluno {

    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        Aluno aluno = (Aluno) o;
        return aluno.getNome().equals(this.nome);
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
