package bancoifmg;

import java.util.*;

public class BancoIFMG {

    public static void iniciarPartida(Posicao jogadoresCadastrados, Tabuleiro tabuleiro) {

        while (jogadoresCadastrados.quantidadeDeJogadores() > 1) {

            //Rodada acontece no for, enquanto o indice não passar por todos os jogadores, o for não termina!
            for (int indice = 0; indice <= jogadoresCadastrados.quantidadeDeJogadores() - 1; indice++) {

                //Informar os dados dos jogadores(Posição, saldo, etc).
                imprimeInformacoes(jogadoresCadastrados, indice);

                Scanner teclado = new Scanner(System.in);
                String aux = teclado.nextLine();
                jogadoresCadastrados.movimentoJogador(indice);

                //Passo 2 - Analisar aonde o jogador parou e fazer as operações logicas do codigo)
                tabuleiro.verificarTipoDaPosicaoTabuleiro(jogadoresCadastrados, tabuleiro, indice);

                //após isso, verificar saldo do jogador
                if (jogadoresCadastrados.retornaSaldo(indice) < 0) {
                    //avisando que ele foi eliminado
                    System.out.println("O jogador " + jogadoresCadastrados.retornaNomeJogador(indice) + " foi eliminado.");
                    //Propriedades existem ainda, posição e etc.
                    System.out.println("Propriedades do jogador " + jogadoresCadastrados.retornaNomeJogador(indice) + " estao disponiveis para compra.\n");
                    //Metodo para excluir as propriedades e a posição do jogador
                    tabuleiro.resetarPropriedades(jogadoresCadastrados, tabuleiro, indice);
                    //Remover jogadores eliminados.
                    tabuleiro.removeJogadorEliminado(indice, jogadoresCadastrados, tabuleiro);
                    //Caso a Quantidade de jogadores seja maior que 1, ele repete a jogada, caso seja igual a um, ele pula esse if, verifica o While e sai do jogo.
                    if (jogadoresCadastrados.getJogadores().size() != 1) {
                        indice--;
                        /* Quando um jogador é eliminado, o da direita cai em sua posição, e logo passa para a proxima rodada(pula um jogador).
                        esse menos no indice garante que o próximo jogador que assumiu a posição jogue na rodada atual. */
                    }
                }
            }
        }
        System.out.println("O JOGADOR " + jogadoresCadastrados.retornaNomeJogador(0) + " FOI O VENCEDOR. PARABENS!!!");
        System.out.println(">>Aperte enter para retornar ao menu inicial...");
        Scanner t = new Scanner(System.in);
        String aux = t.nextLine();
        System.out.print("RETORNANDO AO MENU INICIAL........\n");
    }

    public static void novoJogo(Posicao novoCadastroDosJogadores, Tabuleiro novoTabuleiro) {

        System.out.print("""
        +----------------------------------+
        |         O que voce deseja?       |
        +----------------------------------+
        | (0) - Voltar ao menu inicial     |           
        | (1) - Cadastrar novo jogador     |
        | (2) - Iniciar jogo               |
        +----------------------------------+
        Escolha uma opcao:
                        """);

        // Verificar a entrada se ela realmente eh um valor inteiro dentro do limite (0,1 e 2)
        int opcao = verificarEntrada();
        switch (opcao) {
            case 0:
                menuInicial();
            case 1:

                novoCadastroDosJogadores.iniciaQJogadores();
                novoJogo(novoCadastroDosJogadores, novoTabuleiro);
            case 2:
                iniciarPartida(novoCadastroDosJogadores, novoTabuleiro);
                novoJogo(novoCadastroDosJogadores, novoTabuleiro);
            default:
                System.out.println("Opcao invalida, tente novamente.\n");
                novoJogo(novoCadastroDosJogadores, novoTabuleiro);
        }

    }

    public static void menuInicial() {
       //Crio o novoCadastro na qual os jogadores será inicializados e crio também o novo tabuleiro, iniciandk as posições dele.
        Posicao novoCadastro = new Posicao();
        Tabuleiro novoTabuleiro = new Tabuleiro();
        novoTabuleiro.iniciarJogo();

        System.out.println("""
        ====================================
        |            Bem-vindo(a) ao       |  
        |              Banco IFMG          | 
        ====================================
        |               MENU               |
        ====================================
        |        (0) - Fechar Jogo         |                   
        |        (1) - Iniciar Jogo        |   
        |        (2) - Regras              |  
        ====================================
                  Escolha uma opcao:""");

        //Reutilizo a verificacao da entrada, se ela realmente eh um valor inteiro dentro do limite (0,1 e 2)
        int opcao = verificarEntrada();
        switch (opcao) {
            case 0:
                System.out.println("Encerrando jogo, obrigado por jogar (: ");
                System.exit(0);
            case 1:
                novoJogo(novoCadastro, novoTabuleiro);

            case 2:

                imprimeRegras();
                menuInicial();

            default:
                System.out.println("Opcao invalida, por favor, tente novamente.");
                menuInicial();
        }
    }

    private static void imprimeInformacoes(Posicao jogadoresCadastrados, int indice) {

        System.out.printf("\033\143");
        String nomeJogador = jogadoresCadastrados.retornaNomeJogador(indice);
        int saldoJogador = jogadoresCadastrados.retornaSaldo(indice);
        int posicaoJogador = jogadoresCadastrados.retornaPosicaoJogador(indice);
        String propriedades = jogadoresCadastrados.retornaPropriedade(indice).isEmpty()
                ? "Nenhuma propriedade adquirida."
                : jogadoresCadastrados.retornaPropriedade(indice).toString();

        System.out.println("+-----------------------------------------------+");
        System.out.println("|               Jogo do Banco IFMG              |");
        System.out.println("+-----------------------------------------------+");
        System.out.printf("| Jogador: %-37s|\n", nomeJogador);
        System.out.printf("| Saldo: R$ %-36d|\n", saldoJogador);
        System.out.printf("| Posicao Atual: %-31d|\n", posicaoJogador);
        System.out.println("+-----------------------------------------------+");
        System.out.printf("| Propriedades: %-32s|\n", propriedades);
        System.out.println("+-----------------------------------------------+");
        System.out.println();
        System.out.println("""
                                 |------------------------------------------------|
                                 |       APERTE ENTER PARA JOGAR OS DADOS!!       |
                                 |------------------------------------------------|""");

    }

    public static void imprimeRegras() {
        System.out.println("""
            ===============================
                    REGRAS GERAIS         
            ===============================

            Participacao dos Jogadores:
               - Cada partida deve ter no minimo 2 jogadores e no máximo 6 jogadores cadastrados.
               - Todos os jogadores comecam com o mesmo saldo inicial de R$1500,00.
               - A ordem das jogadas seguirr a ordem de cadastro dos jogadores.

            Regras de Jogadas e Movimentacao:
               - Em cada rodada, os jogadores lancam dois dados.
               - Resultado da soma dos dados: Define a quantidade de casas a avançar no tabuleiro.

            ===============================
                    REGRAS DAS POSICOES    
            ===============================

            1. Compra de Propriedade ou Companhia:
               - O jogador pode comprar o local se:
               - Nao pertencer a outro jogador.
               - Tiver saldo suficiente para a compra.

            2. Taxas de Locacao:
               - Cada ponto turistico possui taxas de locacao especificas.
               - Proprietarios podem incrementar essas taxas ao realizar melhorias (ex.: construir pousadas ou hotéis).

            3. Rodada de Sorte/Reves:
               - Eventos aleatorios que podem gerar ganhos ou perdas para o jogador.

            4. Pagamento de Imposto de Renda:
               - Penalidade de R$200,00 sera deduzida do saldo do jogador.

            5. Melhoramentos em Propriedades:
               - Jogadores proprietarios podem construir pousadas ou hotéis para aumentar a taxa de locação.

            6. Lucros ou Dividendos:
               - O jogador recebe um bonus de R$200,00.

            7. Volta no Tabuleiro:
                - Ao passar pelo ponto inicial, o jogador recebe um premio de R$200,00.

            ===============================
                REGRAS DE COBRANCA DE ALUGUEL
            ===============================

            1. Propriedades ou Companhias pertencentes a outros jogadores:
               - O jogador que cair na propriedade devera pagar uma taxa ao proprietário.
               - O valor depende da situacao da propriedade (lote, pousada ou hotel).

            2. Companhias de Servico:
               - O aluguel eh calculado multiplicando o resultado dos dados por uma taxa.
            Exemplo:
               - O jogador tira 8 nos dados e cai na Companhia Ferroviaria (valor da taxa: 50).
               - Calculo: 8 x 50 = R$400,00
               - O valor sera debitado do saldo do jogador e creditado ao proprietario.

            ===============================
                REGRAS DO FIM DA PARTIDA
            ===============================

            1. Eliminacao de Jogadores:
               - Um jogador eh eliminado se nao tiver saldo suficiente para pagar suas dividas.
               - As propriedades e companhias do jogador eliminado voltam ao tabuleiro e ficam disponiveis para compra.

            2. Condicoes para Vencer:
               - O jogo termina quando apenas um jogador permanece em condicoes financeiras viaveis (nao falido).
               - Este jogador sera declarado o vencedor!
                """);

    }

    public static int verificarEntrada() {
        Scanner teclado = new Scanner(System.in); // Criação do Scanner.
        int opcao = -1; // Coloco um valor para entrar no loop de condicao.
        do {
            try {
                opcao = teclado.nextInt(); // Tratamento de exceção para garantir que o usuario informe valores de ( 0, 1 ou 2)
                if (opcao > 2 || opcao < 0) {
                    System.out.println("Opcao invalida. Tente novamente!\n");
                }
            } catch (InputMismatchException verificaEntrada) {
                // Tratamento de exceção para garantir que o usuario nao informe entradas diferentes de números. 
                System.out.println("Entrada invalida! Digite um numero (0, 1 ou 2).\n");
                teclado.next(); // Limpa a entrada inválida           
            }
        } while (opcao > 2 || opcao < 0);
        return opcao; // Retorna a variavel opção dentro do esperado.
    }

    public static void main(String[] args) {
        menuInicial();
    }   
}
