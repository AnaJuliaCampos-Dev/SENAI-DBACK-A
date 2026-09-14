import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada do tamanho da matriz
        System.out.print("Digite o número de linhas: ");
        int linhas = sc.nextInt();
        System.out.print("Digite o número de colunas: ");
        int colunas = sc.nextInt();

        char[][] matriz = new char[linhas][colunas];

        // Preenchendo da matriz
        System.out.println("\nDigite as letras de cada linha:");
        for (int i = 0; i < linhas; i++) {
            System.out.print("Linha " + (i + 1) + ": ");
            String texto = sc.next().toUpperCase();
            for (int j = 0; j < colunas; j++) {
                if (j < texto.length()) {
                    matriz[i][j] = texto.charAt(j);
                } else {
                    matriz[i][j] = ' ';
                }
            }
        }

        //Entrada das palavras para buscar
        System.out.print("\nQuantas palavras quer buscar? ");
        int qtd = sc.nextInt();
        String[] palavras = new String[qtd];

        for (int i = 0; i < qtd; i++) {
            System.out.print("Palavra " + (i + 1) + ": ");
            palavras[i] = sc.next().toUpperCase();
        }

        // Exibição do caça-palavras
        System.out.println("\n---Caça-Palavras---");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        // Busca de cada palavra
        System.out.println("\n---Resultado---");
        for (int p = 0; p < qtd; p++) {
            String palavra = palavras[p];
            boolean achou = false;

            //Loop para procurar a primeira letra
            for (int l = 0; l < linhas; l++) {
                for (int c = 0; c < colunas; c++) {

                    // Testa as 8 direções 
                    for (int d = 0; d < 8; d++) {
                        if (testarPalavra(matriz, linhas, colunas, l, c, palavra, d)) {
                            
                            // Calcula onde a palavra terminou
                            int fimL = l;
                            int fimC = c;
                            int tam = palavra.length() - 1;

                            if (d == 0) { fimC = c + tam; } // Esquerda -> Direita
                            if (d == 1) { fimC = c - tam; } // Direita -> Esquerda
                            if (d == 2) { fimL = l + tam; } // Cima -> Baixo
                            if (d == 3) { fimL = l - tam; } // Baixo -> Cima
                            if (d == 4) { fimL = l + tam; fimC = c + tam; } // Diagonal Superior Esquerda -> Inferior Direita
                            if (d == 5) { fimL = l - tam; fimC = c - tam; } // Diagonal Inferior Direita -> Superior Esquerda
                            if (d == 6) { fimL = l + tam; fimC = c - tam; } // Diagonal Superior Direita -> Inferior Esquerda
                            if (d == 7) { fimL = l - tam; fimC = c + tam; } // Diagonal Inferior Esquerda -> Superior Direita

                            System.out.println("\nPalavra '" + palavra + "' encontrada");
                            System.out.println("Início : Linha " + (l + 1) + ", Coluna " + (c + 1));
                            System.out.println("Fim    : Linha " + (fimL + 1) + ", Coluna " + (fimC + 1));
                            System.out.println("Direção: " + nomeDirecao(d));

                            achou = true;
                            break;
                        }
                    }
                    if (achou) break;
                }
                if (achou) break;
            }

            if (!achou) {
                System.out.println("\nPalavra '" + palavra + "' não foi encontrada.");
            }
        }

    }

    // MÉTODO TESTAR PALAVRA
    public static boolean testarPalavra(char[][] matriz, int totalL, int totalC, int l, int c, String palavra, int d) {
        int tam = palavra.length();

        //Calcula onde deveria estar a letra da palavra
        for (int k = 0; k < tam; k++) {
            int novaL = l;
            int novaC = c;

            // Ajuste da posição em relação a direção d
            if (d == 0) { novaC = c + k; } // Esquerda para Direita
            if (d == 1) { novaC = c - k; } // Direita para Esquerda
            if (d == 2) { novaL = l + k; } // Cima para Baixo
            if (d == 3) { novaL = l - k; } // Baixo para Cima
            if (d == 4) { novaL = l + k; novaC = c + k; } // Diagonal Superior Esquerda -> Inferior Direita
            if (d == 5) { novaL = l - k; novaC = c - k; } // Diagonal Inferior Direita -> Superior Esquerda
            if (d == 6) { novaL = l + k; novaC = c - k; } // Diagonal Superior Direita -> Inferior Esquerda
            if (d == 7) { novaL = l - k; novaC = c + k; } // Diagonal Inferior Esquerda -> Superior Direita

            // Verifica ultrapassou o limite do caça-palavras
            if (novaL < 0 || novaL >= totalL || novaC < 0 || novaC >= totalC) {
                return false;
            }

            // Verifica se a letra da matriz é diferente da letra da palavra
            if (matriz[novaL][novaC] != palavra.charAt(k)) {
                return false;
            }
        }

        return true;
    }

    // MÉTODO NOME DA DIREÇÃO
    public static String nomeDirecao(int d) {
        if (d == 0) return "Horizontal (Esquerda para Direita)";
        if (d == 1) return "Horizontal (Direita para Esquerda)";
        if (d == 2) return "Vertical (Cima para Baixo)";
        if (d == 3) return "Vertical (Baixo para Cima)";
        if (d == 4) return "Diagonal (Superior Esquerda para Inferior Direita)";
        if (d == 5) return "Diagonal (Inferior Direita para Superior Esquerda)";
        if (d == 6) return "Diagonal (Superior Direita para Inferior Esquerda)";
        if (d == 7) return "Diagonal (Inferior Esquerda para Superior Direita)";
        return "";
    }
}