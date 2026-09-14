import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("---PARES QUE ATIGEM UMA SOMA DESEJADA---");
		
		//Entrada do tamanho do vetor
		System.out.print("\nDigite o tamnho do vetor: ");
		int tamanho = sc.nextInt();
		int[] vetor = new int[tamanho];
		
		//Loop para entrada de todos os elementos
		for (int i=0; i < tamanho; i++){
		    System.out.print("\nDigite o elemento" + i + ": ");
		    vetor[i]= sc.nextInt();
		}
		
		//Entrada do valor alvo
		System.out.print("\nDigite o valor alvo: ");
		int alvo = sc.nextInt();
		
		int contadorPares = 0; //variável que acumula quantidade de pares encontrados
		
		for (int i = 0; i < vetor.length; i++){ //Loop externo que percorre o vetor selecionando o primeiro elemento do par
		    for (int j = i + 1; j < vetor.length; j++){ // loop interno que testa o primeiro elemento com os próximos sem repetir posições
		        
		        //Condicional para verificar se caso a soma for igual  o alvo, exibir os resultado
		        if (vetor[i] + vetor[j] == alvo){
		            System.out.println("\n---Par Encontrado---");
		            System.out.println("Valores: " + vetor[i] + " e " + vetor[j]);
		            System.out.println("Índices: " + i + " e " + j);
		            System.out.println("Soma dos valores: " + (vetor[i] + vetor[j]));
		            contadorPares++; // Soma +1 ao total de pares válidos encontrados
		            
		        }
		    }
		}
		
		//Verifica que se não for entrado a soma = alvo, exibe a mensagem que não foi encontrado
		if (contadorPares == 0) {
		    System.out.println("\nNenhum par atingiu a soma do alvo (" + alvo + ").");
		}
		
	} 
}
