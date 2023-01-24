package main;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

//        cursos.forEach(c -> System.out.println(c.getNome()));

        Stream<String> stream = cursos.stream().map(Curso::getNome);

        OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();

        int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();

        System.out.println(sum);

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(System.out::println);

        List<Curso> list = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toList());

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    }
}
