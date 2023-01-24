package ed.conjunto;

import java.util.HashSet;
import java.util.Set;

public class TesteConjunto {

    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();
        conjunto.adiciona("Mauricio");
        System.out.println(conjunto);

        conjunto.adiciona("Mauricio");
        System.out.println(conjunto);

        conjunto.adiciona("Marcelo");
        System.out.println(conjunto);

        conjunto.adiciona("João");
        System.out.println(conjunto);

        conjunto.remove("Mauricio");
        System.out.println(conjunto);

        // usa hashcode
        Set<String> conjuntoDoJava = new HashSet<>();
        conjuntoDoJava.add("Mauricio");
        conjuntoDoJava.add("Paulo");

        System.out.println(conjuntoDoJava);
    }
}
