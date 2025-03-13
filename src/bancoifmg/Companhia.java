package bancoifmg;

public class Companhia extends Propriedade {

    protected int multiplicacao;

    public Companhia(int multi, int valorDeCompra, String nome) {
        super(valorDeCompra, nome);
        this.multiplicacao = multi;
    }
}
