package banco.test;

import banco.modelo.ContaCorrente;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(11, 11);
        ContaCorrente cc1 = new ContaCorrente(00, 00);
        ContaCorrente cc2 = new ContaCorrente(33, 33);

        List<ContaCorrente> ccs = new ArrayList<>();
        ccs.add(cc);
        ccs.add(cc1);
        ccs.add(cc2);

        ccs.sort(Comparator.co);

    }
}
