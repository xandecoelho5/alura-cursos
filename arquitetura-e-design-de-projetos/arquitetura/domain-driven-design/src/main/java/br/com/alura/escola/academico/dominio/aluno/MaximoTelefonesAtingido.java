package br.com.alura.escola.academico.dominio.aluno;

public class MaximoTelefonesAtingido extends RuntimeException {

    public MaximoTelefonesAtingido() {
        super("Numero maximo de telefones já atingido!");
    }
}
