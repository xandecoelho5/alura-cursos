package builder.casa;

public class Casa {
    private int janelas;
    private int portas;
    private int quartos;
    private boolean temGaragem;
    private boolean temPiscina;
    private boolean temEstatuas;
    private boolean temJardim;

    public void setJanelas(int janelas) {
        this.janelas = janelas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public void setTemGaragem(boolean temGaragem) {
        this.temGaragem = temGaragem;
    }

    public void setTemPiscina(boolean temPiscina) {
        this.temPiscina = temPiscina;
    }

    public void setTemEstatuas(boolean temEstatuas) {
        this.temEstatuas = temEstatuas;
    }

    public void setTemJardim(boolean temJardim) {
        this.temJardim = temJardim;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "janelas=" + janelas +
            ", portas=" + portas +
            ", quartos=" + quartos +
            ", temGaragem=" + temGaragem +
            ", temPiscina=" + temPiscina +
            ", temEstatuas=" + temEstatuas +
            ", temJardim=" + temJardim +
            '}';
}
}
