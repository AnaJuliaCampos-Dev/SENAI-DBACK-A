import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("---ANALISADOR DE TEXTO---");
		System.out.println("Escreva uma frase: ");
		String frase = sc.nextLine();
		
		System.out.print("Escolha uma letra para buscar no texto: ");
		char letra = sc.nextLine().charAt(0); // Pega apenas o primeiro caractere digitado
		
		System.out.println("\n---Resultados Analise---");
		System.out.println("Quantidade de caracteres na frase: " + contarCaracteres(frase));
	    System.out.println("Quantidade de letras na frase: " + contarLetras(frase));
	    System.out.println("Quantidade de vogais na frase: " + contarVogais(frase));
	    System.out.println("Quantidade de consoantes na frase: " + contarConsoantes(frase));
	    System.out.println("Quantidade de algarismos na frase: " + contarAlgarismos(frase));
	    System.out.println("Quantidade de espaços na frase: " + contarEspacos(frase));
	    System.out.println("Quantidade de outros caracteres na frase: " + contarOutros(frase));
	    System.out.println("Quantidade de palavras na frase: " + obterPalavras(frase));
	    System.out.println("Maior palavra encontrada na frase: " + maiorPalavra(frase));
	    System.out.println("Frequência da letra: " + letra + " na frase: " + frequenciaLetra(frase, letra));
		System.out.println("É palindromo: " + seraPalindromo(frase));
	}
	
	// MÉTODO CONTAR CARACTERES
	public static int contarCaracteres(String frase){
	    return frase.length(); // Retorna o tamanho total da string
	}
	
	// MÉTODO CONTAR LETRAS
	public static int contarLetras(String frase){
	    // loop para ver quantos caracteres são letras do alfabeto
	    int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c)){ // Verifica se o caractere é uma letra
                contador++;
            }
        }
        return contador;
	}
	
	//MÉTODO CONTAR VOGAIS
	public static int contarVogais(String frase){
	    int contador = 0;
	    for (int i = 0; i < frase.length(); i++) {
	        char c = frase.charAt(i);
            char min = Character.toLowerCase(c); // Padroniza em minúscula
            if (min == 'a' || min == 'e' || min == 'i' || min == 'o' || min == 'u'){
                contador++;
            }
        }   
        return contador;
	}
	
	//MÉTODO CONTAR CONSOANTES
	public static int contarConsoantes(String frase){
	    int contador = 0;
	    for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            char min = Character.toLowerCase(c);
            // Garante que é uma letra e que não é uma vogal
            if (Character.isLetter(c)==true && (min != 'a' && min != 'e' && min != 'i' && min != 'o' && min != 'u')){
                contador++;
            }
        }   
        return contador;
	}
	
	//MÉTODO CONTAR ALGARISMOS
	public static int contarAlgarismos(String frase){
	    int contador = 0;
	    for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isDigit(c)){ // Verifica se é um número
                contador++;
            }
        }   
        return contador;
	}
	
	//MÉTODO CONTAR ESPAÇOS
	public static int contarEspacos(String frase){
	    int contador = 0;
	    for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (c ==' '){
                contador++; // Conta a quantidade de caracteres de espaço em branco
            }
        }   
        return contador;
	}
	
	//MÉTODO CONTAR OUTROS
	public static int contarOutros(String frase){
	    int contador = 0;
	    for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.isLetter(c)==false && c != ' ' && Character.isDigit(c)==false){
                contador++; // Conta pontuações e símbolos
            }
        }   
        return contador;
	}
	
	//MÉTODO OBTER PALAVRAS
	public static int obterPalavras(String frase){
	    String[] palavras = frase.trim().split("\\s+"); // Remove espaços extras e divide
	    if (frase.trim().isEmpty()) { // Retorna 0 se a frase estiver vazia
	        return 0;
	    } else {
	        return palavras.length; // Retorna o tamanho do vetor de palavras
	    }
	}
	
	//MÉTODO MAIOR PALAVRA
	public static String maiorPalavra(String frase){
	    String[] palavras = frase.trim().split("\\s+");
	    String maior = "";
	    for (String palavra : palavras){
	        if (palavra.length() > maior.length()){
	            maior = palavra; // Atualiza a maior palavra encontrada
	        }
	    }
	    
	    return maior;
	}
	
	//MÉTODO FREQUENCIA LETRA
	public static int frequenciaLetra(String frase, char letra){
	    int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);
            if (Character.toLowerCase(c) == Character.toLowerCase(letra)) {
                contador++; // Conta quantas vezes a letra informada aparece na frase
            }
        } 
        return contador;
    }
	
	//MÉTODO PALINDROMO
	public static boolean seraPalindromo(String frase){
	    String limpa = frase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Mantém apenas letras e números
        String invertida = new StringBuilder(limpa).reverse().toString(); // Inverte o texto
        return limpa.equals(invertida); // Retorna se for idêntica após a inversão
    }
}
