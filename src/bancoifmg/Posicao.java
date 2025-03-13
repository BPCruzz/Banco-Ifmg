package bancoifmg;

import java.util.*;

public class Posicao {

    //ATRIBUTOS//
    private String nomeDaPosicao; //Nome da posição
    private int somaDosDados; //Soma dos dados
    private ArrayList<Jogador> jogadores = new ArrayList(); //Criamos os jogadores(eles pertencem a uma posição).
    private boolean posicaoTemDono; //Informa se a posicao tem dono ou nao.
    private String nomeDoDono; //Informa qual o dono dessa posição especifica (Nome do dono)
    private int indiceDoDono; //Informa o indice do dono.

    //CONSTRUTOR PARA CRIAR UMA NOVA CONSTRUÇÃO//   
    public Posicao() {

    }

    //Construtor da posição
    public Posicao(String nome) {
        this.nomeDaPosicao = nome;
        this.posicaoTemDono = false;
    }

    //METODOS DA POSICAO//
    
    //Inicia a quantidade de jogadores
    public void iniciaQJogadores() {
        //Crio um scanner para perguntar a quantidade de jogadores
        Scanner teclado = new Scanner(System.in);
        int numeroJogadores = -1; // Coloco o valor para que entre no loop de verificacao da quatidade de jogador
        /*Realizo um for para criar a quantidade de jogadores que o usuario informar
        (O If verifica se a quantidade de jogadores está dentro dos limites)*/
        try {
            System.out.print(">>>>>INFORME O NUMERO DE JOGADORES (ENTRE 2 E 6): ");
            numeroJogadores = teclado.nextInt();
            if (numeroJogadores <= 6 && numeroJogadores >= 2) {
                for (int i = 0; i <= numeroJogadores - 1; i++) {
                    // Chama o método para criar novos jogadores e passar o índice para cadastrar na ordem correta
                    cadastraJogador(i);
                }
            } else {
                // Caso o número informado exceda os limites, essa mensagem será exibida
                System.out.println("NUMERO INFORMADO ABAIXO OU ACIMA DO ESPERADO (INFORMAR DE 2 A 6 JOGADORES)");
            }
        } catch (InputMismatchException verificaEntrada) {
            // Captura caso o usuário insira um valor que não seja um número inteiro
            System.out.println("ERRO: Entrada invalida. Por favor, insira um numero inteiro entre 2 e 6.");
        }
    }

    //Cadastra Jogadores
    private void cadastraJogador(int i) {
        //Aqui crio outro Scanner para receber o nome dos jogadores
        Scanner teclado = new Scanner(System.in);
        System.out.print("Informe o nome do jogador: ");
        //Aqui pego o nome do jogador e crio um novo jogador usando o construtor que passa apenas o nome
        String nome = teclado.nextLine();
        Jogador jogador = new Jogador(nome);
        //(Esse I é a posição de cadastro )
        jogadores.add(i, jogador);
    }

    //Retorna quantidade de jogadores na partidade
    public int quantidadeDeJogadores() {
        return jogadores.size();
    }

    //Cadastra Propriedades
    public void cadastradorDePropriedades(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice, Propriedade propriedade) {
        jogadores.get(indice).cadastraNovaPropriedade(propriedade);

    }

    //Sorteio do dado
    public void sortearDado() {
        //Cria uma random
        Random sorteioDado = new Random();
        //Valor primeiro dado
        int dado1 = sorteioDado.nextInt(1, 7);
        System.out.println("Valor do primeiro dado: " + dado1);
        //Valor do segundo dado
        int dado2 = sorteioDado.nextInt(1, 7);
        System.out.println("Valor do segundo dado: " + dado2);
        //Armazena o valor da soma dos dados e mostra ao usuario a soma de ambos
        this.somaDosDados = dado1 + dado2;
        System.out.println("Soma dos dados: " + somaDosDados);
    }

    //Movimentar jogador
    public void movimentoJogador(int indiceDoJogador) { //Esse I é o indice do jogador
        sortearDado();
        jogadores.get(indiceDoJogador).movimentaJogador(somaDosDados);

    }

    //Retorna a posiçao do jogador
    public int retornaPosicaoJogador(int indice) {
        return jogadores.get(indice).getPosicaoDoJogador();
    }

    //Melhora o lote do player
    public void melhoraLote(int indice, int valorDeMelhora) {
        jogadores.get(indice).melhoraPropriedade(valorDeMelhora);
    }

    //Retorna o nome das propriedades pertencentes ao jogagor da vez
    public ArrayList<Propriedade> retornaPropriedade(int indice) {
        return jogadores.get(indice).getPropriedades();
    }

    //Retorna saldo do Jogador
    public int retornaSaldo(int indice) {
        return jogadores.get(indice).getSaldo();
    }

    //Retorna nome do jogador
    public String retornaNomeJogador(int indice) {
        return jogadores.get(indice).getNome();
    }

    //Cadastra novo dono
    public void cadastraDonoNaPosicao(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        this.posicaoTemDono = true;
        this.nomeDoDono = jogadoresCadastrados.retornaNomeJogador(indice);
        this.indiceDoDono = indice;
    }

    //quem paga o aluguel
    public void descontaSaldo(int indice, int valorDaCobranca) {
        jogadores.get(indice).descontaSaldo(valorDaCobranca);
    }

    //quem recebe o valor do aluguel
    public void incrementaSaldo(int indiceDoDono, int valorReceber) {
        jogadores.get(indiceDoDono).incrementaSaldo(valorReceber);
    }

    //TO STRING, GET E SET
    public String getNomeDaPosicao() {
        return nomeDaPosicao;
    }

    public void setNomeDaPosicao(String nomeDaPosicao) {
        this.nomeDaPosicao = nomeDaPosicao;
    }

    public int getSomaDosDados() {
        return somaDosDados;
    }

    public void setSomaDosDados(int somaDosDados) {
        this.somaDosDados = somaDosDados;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public boolean isPosicaoTemDono() {
        return posicaoTemDono;
    }

    public void setPosicaoTemDono(boolean posicaoTemDono) {
        this.posicaoTemDono = posicaoTemDono;
    }

    public String getNomeDoDono() {
        return nomeDoDono;
    }

    public void setNomeDoDono(String nomeDoDono) {
        this.nomeDoDono = nomeDoDono;
    }

    public int getIndiceDoDono() {
        return indiceDoDono;
    }

    public void setIndiceDoDono(int indiceDoDono) {
        this.indiceDoDono = indiceDoDono;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeDaPosicao;
    }

}
