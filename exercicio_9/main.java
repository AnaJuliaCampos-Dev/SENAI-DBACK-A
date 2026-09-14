import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        // Criando a matriz de 5 fileiras x 5 assentos
        char[][] sala = new char[5][5];

        // Loop para preencher e marcar a sala como livre "L" 
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sala[i][j] = 'L';
            }
        }

        int escolha = 0;
        
        // Loop para selecionar umas das opções até digitar 7
        while (escolha != 7) {
            System.out.println("\n---SISTEMA DE RESERVA DE ASSENTOS---");
            System.out.println("1 - Exibir mapa de assentos");
            System.out.println("2 - Reservar um assento");
            System.out.println("3 - Cancelar uma reserva");
            System.out.println("4 - Mostrar total ocupado");
            System.out.println("5 - Fileira mais cheia");
            System.out.println("6 - Procurar conjunto de assentos consecutivos");
            System.out.println("7 - Encerrar");
            
            // Leitura da opção escolhida
            System.out.print("\nEscolha uma opção: ");
            escolha = sc.nextInt();

            // Direcionamento para o método
            if (escolha == 1) {
                exibirMapa(sala);
            } else if (escolha == 2) {
                reservarAssento(sc, sala);
            } else if (escolha == 3) {
                cancelar(sc, sala);
            } else if (escolha == 4) {
                relatorio(sala);
            } else if (escolha == 5) {
                fileiraMaisCheia(sala);
            } else if (escolha == 6) {
                procurarAssentos(sc, sala);
            } else if (escolha == 7) {
                System.out.println("Encerrando o programa...");
            } else {
                System.out.println("Erro: digite somente números de 1 a 7");
            }
        }
    }

    // MÉTODO EXIBIR MAPA
    public static void exibirMapa(char[][] sala) {
        System.out.println("\n---Mapa da Sala---");
        for (int i = 0; i < 5; i++) {
            System.out.print("Fileira " + (i + 1) + ": ");
            for (int j = 0; j < 5; j++) {
                System.out.print("[" + sala[i][j] + "] ");
            }
        }
    }

    // MÉTODO RESERVAR ASSENTO
    public static void reservarAssento(Scanner sc, char[][] sala) {
        System.out.print("\nEscolha uma fileira (1 a 5): ");
        int f = sc.nextInt() - 1; // Subtrai 1 para ajustar ao índice da matriz
        System.out.print("Escolha um assento (1 a 5): ");
        int a = sc.nextInt() - 1;

        // Valida se a posição está dentro dos limites da sala
        if (f < 0 || f >= 5 || a < 0 || a >= 5) {
            System.out.println("Erro: Digite somente números de 1 a 10.");
        } else if (sala[f][a] == 'O') {
            System.out.println("Esse assento já está ocupado.");
        } else {
            sala[f][a] = 'O';
            System.out.println("Assento reservado.");
        }
    }

    // MÉTODO CANCELAR RESERVA
    public static void cancelar(Scanner sc, char[][] sala) {
        System.out.print("\nDigite a fileira (1 a 5): ");
        int f = sc.nextInt() - 1;
        System.out.print("Digite o assento (1 a 5): ");
        int a = sc.nextInt() - 1;

        // Valida limites da matriz
        if (f < 0 || f >= 5 || a < 0 || a >= 5) {
            System.out.println("Erro: digite somente números de 1 a 5");
        } else if (sala[f][a] == 'L') {
            System.out.println("Esse assento já está livre.");
        } else {
            sala[f][a] = 'L';
            System.out.println("Reserva cancelada.");
        }
    }

    // MÉTODO MOSTRAR QUANTIDADE E PORCENTAGEM
    public static void relatorio(char[][] sala) {
        int ocupados = 0;

        // Conta quantos assentos estão ocupados
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (sala[i][j] == 'O') {
                    ocupados++;
                }
            }
        }

        // Calcula a porcentagem com base no total
        double total = 5 * 5;
        double porcentagem = (ocupados / total) * 100;

        System.out.println("\nTotal de assentos ocupados: " + ocupados);
        System.out.println("Porcentagem de ocupação: " + porcentagem + "%");
    }

    // MÉTODO FILEIRA MAIS CHEIA
    public static void fileiraMaisCheia(char[][] sala) {
        int maiorOcupacao = -1;
        int melhorFileira = -1;

        // Percorre fileira por fileira contando os assentos ocupados
        for (int i = 0; i < 5; i++) {
            int cont = 0;
            for (int j = 0; j < 5; j++) {
                if (sala[i][j] == 'O') {
                    cont++;
                }
            }

            // Atualiza qual fileira teve mais reservas até o momento
            if (cont > maiorOcupacao) {
                maiorOcupacao = cont;
                melhorFileira = i + 1; // soma 1 para exibir o número correto
            }
        }

        // Exibe que não foi feita reserva se o maior número foi 0
        if (maiorOcupacao == 0) {
            System.out.println("\nNenhum assento foi reservado ainda.");
        } else {
            System.out.println("\nA fileira mais cheia é a " + melhorFileira + " com " + maiorOcupacao + " assentos ocupados.");
        }
    }

    // MÉTODO PROCURAR ASSENTOS CONSECUTIVOS
    public static void procurarAssentos(Scanner sc, char[][] sala) {
        System.out.print("\nQuantos assentos juntos você precisa? ");
        int quantidade = sc.nextInt();

        // Percorre as fileiras buscando vagas lado a lado
        for (int i = 0; i < 5; i++) {
            int seguidos = 0;
            int inicio = -1;

            for (int j = 0; j < 5; j++) {
                if (sala[i][j] == 'L') {
                    // Guarda o índice onde a sequência de vagas começou
                    if (seguidos == 0) {
                        inicio = j;
                    }
                    seguidos++;

                    // Se atingiu a quantidade ele imprime a localização e encerra
                    if (seguidos == quantidade) {
                        System.out.println("\nDiponibilidade na fileira " + (i + 1) + ", do assento " + (inicio + 1) + " até " + (j + 1));
                        return;
                    }
                } else {
                    
                    seguidos = 0;
                
                    
                }
            }
        }

        // Caso não tenha encontrado a sequência
        System.out.println("Não foram encontrdos assentos vagos juntos.");
    }
}
