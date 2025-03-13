package bancoifmg;

import java.util.ArrayList;

public class Jogador {

    private String nomeDoJogador; //nome do jogador.
    private int saldo; //Saldo do jogador.
    private int posicaoDoJogador; //posicao que o jogador ocupa no tabuleiro.
    private ArrayList<Propriedade> propriedades; //Lista das propriedades que o jogador possui.

    // Construtor para criar um novo jogador.
    public Jogador(String nome) {
        this.nomeDoJogador = nome; //Nome.
        this.saldo = 1500; //Saldo inicial.
        this.posicaoDoJogador = 0; //Posição inicial.
        this.propriedades = new ArrayList(); //Iniciando a lista de propiedades dos jogadores.
    }

    // METODOS DOS JOGADORES//
    
    //Cadastrar novas propriedades
    void cadastraNovaPropriedade(Propriedade propriedade) {
        //Verifica o saldo do jogador e desconta caso ele tenha saldo para comprar propriedade.
        
        if (saldo >= propriedade.valorDeCompra) {
            propriedades.addFirst(propriedade);
            saldo -= propriedade.valorDeCompra;
        } else {
            System.out.println("DINHEIRO INSUFICIENTE!");
        }
    }

    //Incrementa valores na posição do jogador.
    public void movimentaJogador(int somaDosDados) {
        posicaoDoJogador += somaDosDados;
        //Serve para tratar caso a posição do jogador seja maior que o numero de casas no tabuleiro
        if (posicaoDoJogador >= 35) {
            //Se a verificação for verdadeira, ele passou pelo inicio e recebeu +200 reais em seu saldo.
            saldo += 200;
            System.out.println("PARABENS! Voce completou a volta do tabuleiro!! Receba: +200R$ em seu saldo.");
            posicaoDoJogador += -35;

        }
    }

    public void melhoraPropriedade(int valorDeMelhoria) {
        this.saldo -= valorDeMelhoria;
    }

    //Quem paga o valor aluguel.
    public void descontaSaldo(int valorDaCobranca) {
        this.saldo -= valorDaCobranca;
    }

    //Quem recebe o valor do aluguel.
    public void incrementaSaldo(int valorReceber) {
        this.saldo += valorReceber;
    }

    //TO STRING, GET E SET DOS ATRIBUTOS//
    public String getNome() {
        return nomeDoJogador;
    }

    public void setNome(String nome) {
        this.nomeDoJogador = nome;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getPosicaoDoJogador() {
        return posicaoDoJogador;
    }

    public void setPosicaoDoJogador(int posicaoDoJogador) {
        this.posicaoDoJogador = posicaoDoJogador;
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(ArrayList<Propriedade> propriedades) {
        if (this.propriedades == null) {
            System.out.println("O jogador ainda nao possui propriedades!");
        } else {
            this.propriedades = propriedades;
        }

    }

}
