package bancoifmg;

public class Propriedade extends Posicao {

    protected int valorDeCompra;

    public Propriedade(int valorDeCompra, String nome) {
        super(nome);
        this.valorDeCompra = valorDeCompra;
    }

    public int retornaValorDeCompra(){
        int valorDeComprar = valorDeCompra;
        return valorDeComprar;
    }
    
    public int getValorDeCompra() {
        return valorDeCompra;
    }
    
    

}
