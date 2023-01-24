package ed.vetor;

public class VetorTeste {

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Joao");
        Aluno a2 = new Aluno("José");

        Vetor lista = new Vetor();

        System.out.println(lista.tamanho());
        lista.adiciona(a1);
        lista.adiciona(a2);
        System.out.println(lista.tamanho());

        System.out.println(lista);
        System.out.println(lista.contem(a1));

        Aluno a3 = new Aluno("Teste");
        System.out.println(lista.contem(a3));

        Aluno x = lista.pega(1);
        System.out.println(x);

        lista.adiciona(1, a3);
        System.out.println(lista);

        lista.remove(1);
        System.out.println(lista);

        for (int i = 0; i < 300; i++) {
            Aluno u = new Aluno("Joao " + i);
            lista.adiciona(u);
        }
        System.out.println(lista);
    }
}
