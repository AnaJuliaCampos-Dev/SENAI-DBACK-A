import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Loop para passar por todas as opções
		int escolha = 0;
		while (escolha !=7){
		
		System.out.println("\n---CALCULADORA---");
		System.out.println("1 - Soma");
		System.out.println("2 - Subtração");
		System.out.println("3 - Multiplicação");
		System.out.println("4 - Disão");
		System.out.println("5 - Potênciação");
		System.out.println("6 - Resto da Divisão");
		System.out.println("7 - Encerrar");
		
		System.out.print("\nEscolha uma opção: ");
		escolha = sc.nextInt();
		
		//testa para averiguar se a escolha não foi diferente de 1,2,3,4,5,6 e 7
		if (escolha < 1 || escolha > 7){
		    System.out.println("Digite somente números entre 1 e 7");
		} else if (escolha == 7) {
		    System.out.println("Encerrando o programa...");
		} else {
		    System.out.print("\nDigite o primeiro número: ");
		    int num1 = sc.nextInt(); // Entrada do número 1
		    
		    System.out.print("Digite o segundo número: ");
		    int num2 = sc.nextInt(); //Entrada do número 2
		    
		    //direncionamente para os métodos
		    switch (escolha) {
		        case 1:
		            System.out.println("Resultado: " + soma(num1, num2));
		            break;
		        case 2: 
		            System.out.println("Resultado: " + subtracao(num1, num2));
		            break;
		        case 3:
		            System.out.println("Resultado: " + multiplicacao(num1, num2));
		            break;
		        case 4:
		            if (num2 == 0){
		                System.out.println("Erro: não há divisão por 0");
		            } else {
		                System.out.println("Resultado: " + divisao(num1, num2));
		                } 
		                break;
		        case 5:
		            System.out.println("Resultado: " + potenciacao(num1, num2));
		            break;
		        case 6:
		            if (num2 == 0) {
		                System.out.println("Erro: não há divisão por zero");
		            } else {
		                System.out.println("Resultado: " + resto(num1, num2));
		                } 
		                break;
		        
		    }
		  
		    }
		    
		}
		
	}
	
	//MÉTODO SOMA
	public static double soma (double a, double b){
	    return a + b;
	}
	
	//MÉTODO SUBTRAÇÃO
	public static double subtracao (double a, double b){
	    return a - b;
	}
	
	//MÉTODO MULTIPLICAÇÃO
	public static double multiplicacao (double a, double b){
	    return a * b;
	}
	
	//MÉTODO DIVISÃO
	public static double divisao (double a, double b){
	    return a/ b;
	}
	
	//MÉTODO POTENCIACÃO
	public static double potenciacao (double a, double b){
	    return Math.pow(a,b);
	}
	
	//MÉTODO RESTO
	public static double resto (double a, double b){
	    return a % b;
	}
}