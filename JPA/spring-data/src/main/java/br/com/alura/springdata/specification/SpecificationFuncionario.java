package br.com.alura.springdata.specification;

import br.com.alura.springdata.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Funcionario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Funcionario> salario(Double salario) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("salario"), salario);
    }

    public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
    }
}
