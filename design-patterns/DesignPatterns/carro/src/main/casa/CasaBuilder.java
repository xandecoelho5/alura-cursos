package main.casa;

public class CasaBuilder implements Builder<Casa>{

    Casa casa;

    public CasaBuilder() {
        this.casa = new Casa();
    }

    @Override
    public Builder<Casa> construirJanelas(int janelas) {
        this.casa.setJanelas(janelas);
        return this;
    }

    @Override
    public Builder<Casa> construirPortas(int portas) {
        this.casa.setPortas(portas);
        return this;
    }

    @Override
    public Builder<Casa> construirQuartos(int quartos) {
        this.casa.setQuartos(quartos);
        return this;
    }

    @Override
    public Builder<Casa> construirGaragem() {
        this.casa.setTemGaragem(true);
        return this;
    }

    @Override
    public Builder<Casa> construirPiscina() {
        this.casa.setTemPiscina(true);
        return this;
    }

    @Override
    public Builder<Casa> construirEstatuas() {
        this.casa.setTemEstatuas(true);
        return this;
    }

    @Override
    public Builder<Casa> construirJardim() {
        this.casa.setTemJardim(true);
        return this;
    }

    public Casa build() {
        return this.casa;
    }
}
