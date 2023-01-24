package builder.casa;

public class Main {
    public static void main(String[] args) {
        Casa casa = new CasaBuilder()
                .construirJanelas(4)
                .construirPortas(5)
                .construirQuartos(3)
                .construirJardim()
                .build();
        Casa casa2 = new CasaBuilder()
                .construirJanelas(2)
                .construirPortas(6)
                .construirQuartos(2)
                .construirGaragem()
                .construirEstatuas()
                .build();
        System.out.println(casa);
        System.out.println(casa2);
    }
}
