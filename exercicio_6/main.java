import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("---RANKING DE TEMPOS DE UMA COMPETIÇÃO---");
        
        //Entrada de dados da quantidade de participantes
        System.out.println("Bem vindo, informe quantos participantes estão competindo: ");
        int participantes = sc.nextInt();
        sc.nextLine(); 
        
        String[] nome = new String[participantes];
        double[] tempo = new double[participantes];
        
        //Entrada dos dados dos nomes dos participantes e seus tempos
        for (int i = 0; i < participantes; i++) {
            
            System.out.print("Digite o nome do participante " + (i + 1) + ": ");
            nome[i] = sc.nextLine(); 
            
            System.out.print("Digite o tempo do participante " + (i + 1) + ": ");
            tempo[i] = sc.nextDouble(); 
            sc.nextLine();
        }
        
        //lista dos participantes e seus tempos
        System.out.println("\n---Lista Completa de Participantes---");
        for (int i = 0; i < participantes; i++) {
            System.out.println(" Participante: " + nome[i] + " - Tempo: " + tempo[i] + " s");
            
        }
        
        //ETAPA 2
        //Média
        System.out.println("\n---Média dos Participantes---");
        double soma = 0;
        for (int i = 0; i < tempo.length; i++) {
            soma+= tempo[i];}
        double media = soma/participantes; {
            System.out.println(" A média geral é: " + media);
        }
        
        //Baixo da Média
        int baixomedia = 0;
        for (int i = 0; i < tempo.length; i++) {
            if (tempo[i] < media) {
            baixomedia++;
            }
        }
        
        System.out.println(" A quantidade de participantes abaixo da média é: " + baixomedia);
        
        //ETAPA 3
        //Ordenação
        for (int j = 0; j < participantes; j++) {
            for (int i = 0; i < participantes - 1; i++) {
                if (tempo[i] > tempo[i + 1]) {
                    double aux = tempo[i];
                    tempo[i] = tempo[i + 1];
                    tempo[i + 1] = aux;
                    
                    String auxNome = nome[i];
                    nome[i] = nome[i + 1];
                    nome[i + 1] = auxNome;
                }
            }
        } 
        
        System.out.println("\n---Participante Mais Rápido e o Mais Lento---");
        System.out.println(" Mais Rápido: " + nome[0] + " com " + tempo[0] + "s");
        System.out.println(" Mais Lento: " + nome[participantes - 1] + " com " + tempo[participantes - 1] + "s");
        
        //ETAPA 4
        //Ranking completo
        System.out.println("\n----Ranking completo----");
        for (int i = 0; i < participantes; i++) {
            System.out.println(" " + (i + 1) +"º Lugar: " + nome[i] + " - " + tempo[i] + "s");
        }
        
        //ETAPA 5
        //Mediana
       System.out.println("\n---Mediana e Desvio Padrão---"); 
       double mediana;
        
        if (tempo.length % 2 == 0){
            mediana = ((double)tempo[tempo.length/2] + (double)tempo[tempo.length/2 - 1])/2;
        }else{
        mediana = (double) tempo[tempo.length/2];
        }
        System.out.println(" Mediana: " + mediana);
        
        //Desvio Padrão
        
        double sum = 0.0, standardDeviation = 0.0;
        int length = tempo.length;

        for(double num : tempo) {
            sum += num;
        }

        double mean = sum/length;

        for(double num: tempo) {
            standardDeviation += Math.pow(num - mean, 2);
        }
        
        System.out.printf(" Desvio Padrão: %.2f", Math.sqrt(standardDeviation / length));

    }
}
