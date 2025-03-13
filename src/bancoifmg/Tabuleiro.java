package bancoifmg;

import java.util.*;

public class Tabuleiro {

    private Posicao[] casasDoTabuleiro; //Cria as casas do tabuleiro
    static Scanner teclado = new Scanner(System.in); //Crio um Scanner static por que vou usar ele varias vezes

    public void iniciarJogo() {

        this.casasDoTabuleiro = new Posicao[36]; //Inicia as 36 casas do tabuleiro

        /* Identificação da Posições do tipo Lote que possui o mesmo valor de(aluguel/pousada/hotel ).
        E repetindo o array de valor correpondente a posição com o objetivo de otimizar o codigo e nao 
        criar array com valores iguais. exemplo da: Av. Europa e Av. Pacaembu.
         */
        int valores0[] = {8, 24, 240};
        int valores1[] = {6, 18, 180};
        int valores2[] = {7, 21, 210};
        int valores3[] = {13, 39, 390};
        int valores4[] = {11, 33, 330};
        int valores5[] = {12, 36, 360};
        int valores6[] = {10, 30, 300};
        int valores7[] = {9, 27, 270};
        int valores8[] = {35, 105, 1050};
        int valores9[] = {50, 150, 1500};
        int valores10[] = {15, 45, 450};
        int valores11[] = {21, 63, 630};
        int valores12[] = {23, 69, 690};
        int valores13[] = {22, 66, 660};
        int valores15[] = {28, 84, 840};

        //Iniciamos as casas do tabuleiro.
        this.casasDoTabuleiro[0] = new Lote(valores0, 80, "Leblon");
        this.casasDoTabuleiro[1] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[2] = new Lote(valores1, 80, "Av. Presidente Vargas");
        this.casasDoTabuleiro[3] = new Lote(valores2, 80, "Av. Nossa Senhora de Copacabana");
        this.casasDoTabuleiro[4] = new Companhia(50, 200, "Companhia Ferroviaria");
        this.casasDoTabuleiro[5] = new Lote(valores3, 110, "Av. Brigadeiro Faria Lima");
        this.casasDoTabuleiro[6] = new Companhia(40, 200, "Companhia de Viacao");
        this.casasDoTabuleiro[7] = new Lote(valores4, 110, "Av. Reboucas");
        this.casasDoTabuleiro[8] = new Lote(valores5, 110, "Av. 9 de Julho");
        this.casasDoTabuleiro[9] = new Lote(valores6, 100, "Av. Europa");
        this.casasDoTabuleiro[10] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[11] = new Lote(valores7, 100, "Rua Augusta");
        this.casasDoTabuleiro[12] = new Lote(valores6, 100, "Av. Pacaembu");
        this.casasDoTabuleiro[13] = new Companhia(40, 200, "Companhia de Taxi");
        this.casasDoTabuleiro[14] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[15] = new Lote(valores8, 250, "Interlagos");
        this.casasDoTabuleiro[16] = new Fixo(+200, "Lucros ou Dividendos");
        this.casasDoTabuleiro[17] = new Lote(valores9, 250, "Morumbi");
        this.casasDoTabuleiro[18] = new Lote(valores4, 100, "Bangu");
        this.casasDoTabuleiro[19] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[20] = new Lote(valores6, 100, "Botafogo");
        this.casasDoTabuleiro[21] = new Fixo(-200, "Imposto de Renda");
        this.casasDoTabuleiro[22] = new Companhia(40, 200, "Companhia de Navegacao");
        this.casasDoTabuleiro[23] = new Lote(valores3, 110, "Av. Brasil");
        this.casasDoTabuleiro[24] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[25] = new Lote(valores10, 110, "Av. Paulista");
        this.casasDoTabuleiro[26] = new Lote(valores5, 110, "Jardim Europa");
        this.casasDoTabuleiro[27] = new Lote(valores11, 170, "Copacabana");
        this.casasDoTabuleiro[28] = new Companhia(50, 200, "Companhia de Aviacao");
        this.casasDoTabuleiro[29] = new Lote(valores12, 170, "Av. Vieira Souto");
        this.casasDoTabuleiro[30] = new Lote(valores12, 170, "Av. Atlantica");
        this.casasDoTabuleiro[31] = new Companhia(50, 200, "Companhia de Taxi Aareo");
        this.casasDoTabuleiro[32] = new Lote(valores13, 170, "Ipanema");
        this.casasDoTabuleiro[33] = new Sorte("Sorte/Reves");
        this.casasDoTabuleiro[34] = new Lote(valores15, 190, "Jardim Paulista");
        this.casasDoTabuleiro[35] = new Lote(valores13, 190, "Brooklin");

    }

    // VERIFICA A CLASSE DA POSICAO.
    public void verificarTipoDaPosicaoTabuleiro(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {

        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)] instanceof Lote) {
            System.out.println("Voce parou em: " + tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDaPosicao());
            casoLote(jogadoresCadastrados, tabuleiro, indice);
        }
        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)] instanceof Companhia) {
            System.out.println("Voce parou na: " + tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDaPosicao());
            casoCompanhia(jogadoresCadastrados, tabuleiro, indice);
        }
        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)] instanceof Sorte) {
            System.out.println("Voce parou no:  " + tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDaPosicao());
            casoSorteReves(jogadoresCadastrados, tabuleiro, indice);
        }
        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)] instanceof Fixo) {
            System.out.println("Voce parou em uma posicao fixa " + tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDaPosicao());
            casoFixo(jogadoresCadastrados, tabuleiro, indice);
        }

    }

    //CASO SEJA LOTE E SEUS METODOS
    public void casoLote(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        //Recebe a posição atual do jogador(A casa o qual está, e depois transforma em lote)
        Posicao posicaoAtual = tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)];
        Lote lote = (Lote) posicaoAtual; //Casting de Posicao para Lote para facilitar as operacoes
        boolean temDono = verificaSeTemDono(jogadoresCadastrados, tabuleiro, indice);
        boolean jogadorQueCaiuIsDono = verificaSeIsDono(jogadoresCadastrados, tabuleiro, indice);
        boolean resposta;
        
        //Passo 1 - Saber se tem dono ou não 

        if (temDono == false) {
            //Aqui eu faco as operacoes caso ele queira comprar a proriedade
            resposta = desejaComprarLote(lote);
            if (resposta == true) {
                //Se for sim, fazer as operacoes de compras              
                if (jogadoresCadastrados.retornaSaldo(indice) >= lote.valorDeCompra) {
                    tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].cadastraDonoNaPosicao(jogadoresCadastrados, tabuleiro, indice);
                    jogadoresCadastrados.cadastradorDePropriedades(jogadoresCadastrados, tabuleiro, indice, lote);
                }else{
                    System.out.println("Dinheiro insuficiente para adquirir a propriedade!!!");
                }
            } else {
                System.out.println("O Jogador optou por nao comprar a propriedade");
            }

        } else {
            //Verificar se o dono da posição é o jogador que caiu
            if (jogadorQueCaiuIsDono == true) {
                //quer dizer que quem caiu é o dono
                melhorarLote(jogadoresCadastrados, tabuleiro, indice, lote);
            } else {
                //quer dizer que quem caiu não é o dono
                //Aqui ele deve pagar um valor para o dono do lote
                pagarAoDonoDoLote(jogadoresCadastrados, tabuleiro, indice, lote);
            }
        }

    }

    //metodo das cobranças
    public void pagarAoDonoDoLote(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice, Lote lote) {
        int valorDoAluguel = lote.valorDeNivel[lote.nivel];
        System.out.println("Jogador pagou " + valorDoAluguel + " ao dono da propriedade.");
        jogadoresCadastrados.descontaSaldo(indice, valorDoAluguel);
        jogadoresCadastrados.incrementaSaldo(tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getIndiceDoDono(), valorDoAluguel);

    }

    //metodo da melhora do lote
    public void melhorarLote(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice, Lote lote) {

        if (lote.nivel < 2) {
            System.out.println("Deseja melhorar sua propriedade por " + lote.valorDeNivel[lote.nivel + 1] + "R$? (sim/nao)");
            String resposta = teclado.nextLine();

            if (resposta.equals("sim")) {
                if (jogadoresCadastrados.retornaSaldo(indice) > lote.valorDeNivel[lote.nivel + 1]) {
                    jogadoresCadastrados.melhoraLote(indice, lote.valorDeNivel[lote.nivel + 1]);
                    lote.nivel++;
                } else {
                    System.out.println("Saldo do jogador insuficiente para a melhora da propriedade");
                }
            } else {
                System.out.println("Jogador optou por nAo melhorar sua propriedade");
            }
        }

    }

    //caso a pessoa queira comprar o lote
    public boolean desejaComprarLote(Lote lote) {
        System.out.println("Deseja comprar a propriedade pelo valor de " + lote.valorDeCompra + "R$ ?(sim/nao)");
        String resposta = teclado.nextLine();
        if (resposta.equals("sim")) {
            return true;
        }
        return false;

    }

    //CASO COMPANHIA E SEUS METODOS
    public void casoCompanhia(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        Posicao posicaoAtual = tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)]; //recebe a posição atual do tabuleiro
        Companhia companhia = (Companhia) posicaoAtual; //Casting de Posicao para Lote para facilitar as operacoes
        boolean temDono = verificaSeTemDono(jogadoresCadastrados, tabuleiro, indice); //verifica se tem dono
        boolean jogadorQueCaiuIsDono = verificaSeIsDono(jogadoresCadastrados, tabuleiro, indice); //verifica se o jogador que caiu é o dono
        boolean resposta; //temporaria que recebe a resposta

        if (temDono == false) {
            //não tem dono
            resposta = desejaComprarCompanhia(companhia);
            //opcao de comprar 
            if (resposta == true) {
               
                if (jogadoresCadastrados.retornaSaldo(indice) >= companhia.valorDeCompra) {
                    tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].cadastraDonoNaPosicao(jogadoresCadastrados, tabuleiro, indice);
                     jogadoresCadastrados.cadastradorDePropriedades(jogadoresCadastrados, tabuleiro, indice, companhia);                  
                }else{
                    System.out.println("Dinheiro insuficiente para adquirir a propriedade!!!");
                }               
            } else {
                System.out.println("Jogador optou por nao comprar a companhia");
            }

        } else {
            //quer dizer que tem dono
            if (jogadorQueCaiuIsDono == true) {
                //verificar se ele é o dono
                System.out.println("Voce eh o dono dessa propriedade");
            } else {
                //se ele não for, fazer cobrança
                pagarAoDonoDaCompanhia(jogadoresCadastrados, tabuleiro, indice, companhia);
            }

        }

    }

    //Caso jogador queira comprar companhia
    public boolean desejaComprarCompanhia(Companhia companhia) {
        System.out.println("Deseja adquirir essa companhia por " + companhia.valorDeCompra + "R$ ?(sim/nao)");
        String resposta = teclado.nextLine();
        if (resposta.equals("sim")) {
            return true;
        }
        return false;
    }

    //paga ao dono da companhia
    private void pagarAoDonoDaCompanhia(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice, Companhia companhia) {
        int valorDaMultiplicacao = companhia.multiplicacao * jogadoresCadastrados.getSomaDosDados();
        System.out.println("Jogador pagou " + valorDaMultiplicacao + " ao dono da propriedade.");
        jogadoresCadastrados.descontaSaldo(indice, valorDaMultiplicacao);
        jogadoresCadastrados.incrementaSaldo(tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getIndiceDoDono(), valorDaMultiplicacao);

    }

    //METODOS PARA SITUAÇÕES GERAIS
    
    //Verifica se é o dono
    public boolean verificaSeIsDono(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {

        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDoDono() == null) {
            return false;

        }
        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDoDono()
                .equals(jogadoresCadastrados.retornaNomeJogador(indice))) {
            System.out.println("Voce caiu em uma de suas propriedades. ");
            return true;
        }
        System.out.println("Voce caiu na propriedade do jogador " + tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].getNomeDoDono());
        return false;
    }

    //verifica se tem dono
    public boolean verificaSeTemDono(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        //verifica se a posição tem dono
        
        if (tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)].isPosicaoTemDono() == false) {
            //se for falso(não tem dono)
            return false;
        }
        //se for diferente de falso, tem dono
        return true;
    }

    //SORTE E REVÉS E SEUS METÓDOS
    
    public void casoSorteReves(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        Posicao posicaoAtual = tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)];
        Sorte sorte = (Sorte) posicaoAtual; //Casting de Posicao para sorte para facilitar as operacoes
        imprimeSorteEModificaSaldo(sorte, jogadoresCadastrados, tabuleiro, indice);

    }

    //Imprime o valor do sorte e modifica saldo
    public void imprimeSorteEModificaSaldo(Sorte sorte, Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        sorte.sorteio();
        if (sorte.sorteReves > 0) {
            System.out.println("Parabens, voce esta em um dia de sorte, receba: " + "+" + sorte.sorteReves + "R$");
            jogadoresCadastrados.incrementaSaldo(indice, sorte.sorteReves);
        } else {
            if (sorte.sorteReves < 0) {
                System.out.println("Voce esta com azar ): Pague: " + -sorte.sorteReves + "R$");
                jogadoresCadastrados.descontaSaldo(indice, -sorte.sorteReves);
            } else {
                if (sorte.sorteReves == 0) {
                    System.out.println("Ficou no 0 a 0. ");
                }
            }

        }
    }

    //CASO FIXO E SEUS METODOS
    public void casoFixo(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {
        Posicao posicaoAtual = tabuleiro.casasDoTabuleiro[jogadoresCadastrados.retornaPosicaoJogador(indice)];
        Fixo fixo = (Fixo) posicaoAtual; //Isso aqui é Casting de Posicao para Fixo para facilitar as operacoes
        verificaFixoEDescontaSaldo(fixo, jogadoresCadastrados, tabuleiro, indice);

    }

    //Verifica casa e desconta saldo
    public void verificaFixoEDescontaSaldo(Fixo fixo, Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indice) {

        if (jogadoresCadastrados.retornaPosicaoJogador(indice) == 16) {
            System.out.println("Voce recebeu lucros e dividendos. +200R$ em seu saldo");
            jogadoresCadastrados.incrementaSaldo(indice, 200);

        } else {
            if (jogadoresCadastrados.retornaPosicaoJogador(indice) == 21) {
                System.out.println("Voce caiu no leao da receita federal. -200R$ em seu saldo");
                jogadoresCadastrados.descontaSaldo(indice, 200);

            }
        }
    }

    //reseta as propriedades do jogador eliminado
    public void resetarPropriedades(Posicao jogadoresCadastrados, Tabuleiro tabuleiro, int indiceJogadorEliminado) {

        //Passo 1 - descobrir jogador a ser eliminado e excluir seu array list de propriedades(limpou o array list do jogador).
        jogadoresCadastrados.getJogadores().get(indiceJogadorEliminado).getPropriedades().clear();
        //Passo 2 - descadastrar as propriedades do indice dele(definir as propriedades como null).
        for (int posicaoVerificada = 0; posicaoVerificada < tabuleiro.casasDoTabuleiro.length; posicaoVerificada++) {
            //aqui eu passo por todas as casas.
            if (tabuleiro.casasDoTabuleiro[posicaoVerificada].getIndiceDoDono() == indiceJogadorEliminado
                    && tabuleiro.casasDoTabuleiro[posicaoVerificada] instanceof Companhia) {
                //consegue descobrir se é dono ou não e se É uma companhia.
                tabuleiro.casasDoTabuleiro[posicaoVerificada].setPosicaoTemDono(false);
                //definindo que ela não tem dono .
                tabuleiro.casasDoTabuleiro[posicaoVerificada].setNomeDoDono(null);
                //definiu nome igual a null.

            }

            if (tabuleiro.casasDoTabuleiro[posicaoVerificada].getIndiceDoDono() == indiceJogadorEliminado
                    && tabuleiro.casasDoTabuleiro[posicaoVerificada] instanceof Lote) {
                //Verifico novamente se o indice do dono é o mesmo do jogador eliminado.
                Posicao posicaoAtual = tabuleiro.casasDoTabuleiro[posicaoVerificada];
                Lote lote = (Lote) posicaoAtual; //Casting.

                //Aqui eu reinicio o nivel de lote.
                lote.nivel = 0;

                //falamos que não tem dono.
                tabuleiro.casasDoTabuleiro[posicaoVerificada].setPosicaoTemDono(false);
                //falamos que é nullo o nome do dono.
                tabuleiro.casasDoTabuleiro[posicaoVerificada].setNomeDoDono(null);
            }

        }
    }

    public void removeJogadorEliminado(int indiceJogadorEliminado, Posicao jogadoresCadastrados, Tabuleiro tabuleiro) {
        //Primeiro passo - Remover o jogador do indice e organiza os jogadores passando os elementos para a esquerda
        jogadoresCadastrados.getJogadores().remove(indiceJogadorEliminado);//lembrando que esse .remove já faz isso automaticamente
        //agora precisamos então de atualizar os indices das propriedades
        // Atualizar as propriedades
        for (int indicePropriedadeAnalisada = 0; indicePropriedadeAnalisada < tabuleiro.casasDoTabuleiro.length; indicePropriedadeAnalisada++) {

            //Dono recebe o indice do dono da propriedade analisada
            int dono = tabuleiro.casasDoTabuleiro[indicePropriedadeAnalisada].getIndiceDoDono();

            // Se o índice do dono for maior que o jogador removido, ajusta o indice para valores que existem

            /*
            Como fica na pratica? 
            se o indice do dono for 5, quando a gente usa o remove, o indice do dono é 4, porem o array list de propriedades não atualizava
            isso causava o seguinte problema: quando chamavamos o metodo de pagamento e pegavamos o indice do dono (5) dava erro, pq o tamanho do array list de 
            jogadores era apenas 4, isso dava erro de indice fora dos limites, com isso, se Dono(5) > jogadorEliminado(4) 
            vamos pegar o indice do dono(5) e fazer - 1()fazendo o indice ficar dentro dos limites do array list de jogadores.
            (6 HORAS PARA RESOLVER ISSO KKKKKKKKKKKKKKK  '-').
             */
            if (dono > indiceJogadorEliminado) {
                //aqui eu falo que o dono da posição é -1 (igual ao que o .remove faz)
                tabuleiro.casasDoTabuleiro[indicePropriedadeAnalisada].setIndiceDoDono(dono - 1);
            }
        }

    }

}
