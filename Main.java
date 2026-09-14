import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("---ESTATÍSTICA DE UMA SEQUÊNCIA NUMÉRICA---");
	
	//Memória da variavél, onde guarda os números
	int total = 0;
	int soma = 0;
	int positivos = 0;
	int negativos = 0;
	int pares = 0;
	int impares = 0;
	int multiplos3 = 0;
	
	//Inicia a leitura com um coparador de limites extremos para maior e menor
	int maior = Integer.MIN_VALUE;
    int menor = Integer.MAX_VALUE;
	
	//Loop para repetir a entrada de números até atingir 0
	while (true){
	    
	    System.out.print("Digite um número: ");
	    int numeros = sc.nextInt();

	    if (numeros == 0){
	        break;
	    } //Verica se o usuário digitou 0 para encerrar o loop
	    
	    //Atualiza contadores
	    total = numDigitados(total);
	    soma = numSoma(soma, numeros);
	    maior = numMaior(maior, numeros);
	    menor = numMenor(menor, numeros);
        positivos = numPositivos(positivos, numeros);
        negativos = numNegativos(negativos, numeros);
        pares = numPar(pares, numeros);
        impares = numImpar(impares, numeros);
        multiplos3 = multiploTres(multiplos3, numeros);
        
	} //Fechamento do loop
	
	//Print dos resultados
	System.out.println("\n---ESTATÍSTICAS---");
	if (total == 0){
	    System.out.println("Nenhum número válido foi digitado.");
	} else{
	System.out.println("Quantidade de números digitados: " + total);
	System.out.println("Soma de todos os valores: " + soma );
	System.out.println("Média de todos os valores: " + numMedia(soma, total));
	System.out.println("Maior valor: " + maior );
	System.out.println("Menor valor: " + menor);
	System.out.println("Quantidade de valoes positivos: " + positivos);
	System.out.println("Quantidade de valores negativos: " + negativos);
	System.out.println("Quantidade de valores ímpares: " + impares);
	System.out.println("Quantidade de valores pares: " + pares);
	System.out.println("Quantidade de multiplos de três: " + multiplos3);
	} //Fechamento da condicional
	
	}//Fechamento do método main

	
	//MÉTODO TOTAL DIGITADO
	public static int numDigitados(int qtdAtual){
	    return qtdAtual + 1;
	}
	
	//MÉTODO SOMA
	public static int numSoma(int somaAtual, int numero){
	    return somaAtual + numero;
	}

	//MÉTODO MÉDIA
	public static double numMedia(int soma, int total){
	    return (double) soma / total;
	}
	
	//MÉTODO MAIOR NÚMERO
	public static int numMaior(int maiorAtual, int numero){
	    if (numero > maiorAtual){
	        return numero;
	    }
	    return maiorAtual;
	}
	
	//MÉTODO MENOR NÚMERO
	public static int numMenor(int menorAtual, int numero){
	    if (numero < menorAtual){
	        return numero;
	    }
	    return menorAtual;
	}
	
	//METODO NÚMEROS POSITIVOS
	public static int numPositivos(int qtdAtual, int numero){
	    if (numero > 0) {
	        return qtdAtual + 1;
	    }
	    return qtdAtual;
	}
	
	//MÉTODO NÚMEROS NEGATIVOS
	public static int numNegativos(int qtdAtual, int numero){
	    if (numero < 0) {
	        return qtdAtual + 1;
	    }
	    return qtdAtual;
	}
	
	//MÉTODOS NÚMEROS PARES
	public static int numPar(int qtdAtual, int numero){
	    if (numero % 2 == 0){
	        return qtdAtual + 1;
	    }
	    return qtdAtual;
	}
	
	//MÉTODOS NÚMEROS ÍMPARES
	public static int numImpar(int qtdAtual, int numero){
	    if (numero % 2 !=0){
	        return qtdAtual + 1;
	    }
	    return qtdAtual;
	}
	
	//MÉTODO MULTIPLOS DE 3
	public static int multiploTres(int qtdAtual, int numero){
	    if (numero % 3 == 0){
	        return qtdAtual + 1;
	    }
	    return qtdAtual;
	}
}