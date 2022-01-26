package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        // MOCK -> Mockito
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());

        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-00", "fulano@email.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCPF(new CPF("123.456.789-00"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-00", encontrado.getCpf().getNumero());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }

}
