package bancoifmg;

import java.util.Random;

public class Sorte extends Posicao {

    protected int sorteReves;
    Random sorteio = new Random();

    public Sorte(String nome) {
        super(nome);
        this.sorteReves = sorteio.nextInt(-80, 150);
    }
    
    public void sorteio(){
        this.sorteReves = sorteio.nextInt(-80, 150);
    } 
}
