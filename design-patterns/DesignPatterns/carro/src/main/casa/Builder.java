package main.casa;

public interface Builder<T> {
    Builder<T> construirJanelas(int janelas);
    Builder<T> construirPortas(int portas);
    Builder<T> construirQuartos(int quartos);
    Builder<T> construirGaragem();
    Builder<T> construirPiscina();
    Builder<T> construirEstatuas();
    Builder<T> construirJardim();
    T build();
}
