package bancoifmg;

public class Fixo extends Posicao {
    private int fixo;

    public Fixo(int fixo, String nome) {
        super(nome);
        this.fixo = fixo;
    }
}
