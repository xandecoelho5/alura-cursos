package br.com.alura.springdata;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import br.com.alura.springdata.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Boolean system = true;

    private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
    private final RelatoriosService relatoriosService;
    private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

    public SpringDataApplication(CrudCargoService cargoService,
                                 CrudFuncionarioService funcionarioService,
                                 CrudUnidadeTrabalhoService unidadeTrabalhoService,
                                 RelatoriosService relatoriosService,
                                 RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatoriosService = relatoriosService;
        this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (system) {
            System.out.println("Qual função deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionário");
            System.out.println("3 - Unidade");
            System.out.println("4 - Relatórios");
            System.out.println("5 - Relatório Dinâmico");

            Integer function = scanner.nextInt();

            switch (function) {
                case 1:
                    cargoService.inicial(scanner);
                    break;
                case 2:
                    funcionarioService.inicial(scanner);
                    break;
                case 3:
                    unidadeTrabalhoService.inicial(scanner);
                    break;
                case 4:
                    relatoriosService.inicial(scanner);
                    break;
                case 5:
                    relatorioFuncionarioDinamico.inicial(scanner);
                    break;
                default:
                    System.out.println("Finalizando");
                    system = false;
                    break;
            }
        }
    }
}
