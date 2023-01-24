package main.casa;

public class Main {
    public static void main(String[] args) {
        Casa casa = (Casa) new CasaBuilder()
                .construirJanelas(4)
                .construirPortas(5)
                .construirQuartos(3)
                .construirJardim()
                .build();
        System.out.println(casa);
    }
}
