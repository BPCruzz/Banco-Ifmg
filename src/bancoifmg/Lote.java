package bancoifmg;

public class Lote extends Propriedade {
    
    protected int[] valorDeNivel;
    protected int nivel;
    
    /*
    Nivel 0 = proriedade paga valor de aluguel.
    Nivel 1 = pousada.
    nivel 2 = hotel.
   
    metodo de cobranca de alguel. se status for TRUE.
    Quando o adversario cair na posicao com proprietario criar um escolha caso
    caso nivel 0 = cobrar valor do aluguel.
    caso nivel 1 = cobrar valor pousada.
    caso nivel 2 = cobrar valor hotel.
    
  
    STATUS TRUE E DONO FOR IGUAL A ELE MESMO.
    se o prorietario for o prorio dono da propriedade.
    caso nivel 0 = cobrar valor pousada para upar
    caso nivel 1 = cobrar valor hotel para upar.
    
    */
   
    public Lote(int[] ValorDeNivel, int valorDeCompra, String nome) {
        super(valorDeCompra, nome);
        this.valorDeNivel = ValorDeNivel;
        this.nivel = 0;
    }



    
    
    
    
    

   
}
