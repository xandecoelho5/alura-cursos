package ed.listaligada;

public class TestaListaLigada {

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();

        System.out.println(lista);
        lista.adicionaNoComeco("mauricio");
        System.out.println(lista);
        lista.adicionaNoComeco("paulo");
        System.out.println(lista);
        lista.adicionaNoComeco("guilherme");
        System.out.println(lista);

        lista.adiciona("Marcelo");
        System.out.println(lista);

        lista.adiciona(2, "Gabriel");
        System.out.println(lista);

        Object x = lista.pega(2);
        System.out.println(x);

        System.out.println(lista.tamanho());

        lista.removeDoComeco();
        System.out.println(lista);
        System.out.println(lista.tamanho());

        lista.removeDoFim();
        System.out.println(lista);

        lista.adiciona("José");
        lista.adiciona("João");
        System.out.println(lista);
        lista.remove(2);
        System.out.println(lista);

        System.out.println(lista.contem("Mauricio"));
        System.out.println(lista.contem("João"));
    }
}
