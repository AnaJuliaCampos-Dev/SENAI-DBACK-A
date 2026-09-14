import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Olá, digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite a primeira nota de 0 a 10: ");
        double nota1 = sc.nextDouble();

        System.out.println("Digite a segunda nota de 0 a 10: ");
        double nota2 = sc.nextDouble();

        System.out.println("Digite a terceira nota de 0 a 10: ");
        double nota3 = sc.nextDouble();

        System.out.println("Digite o percentual de frequência (sem o símbolo de porcentagem %): ");
        double frequencia = sc.nextDouble();

        double media = resultadoSituacaoAcademica(nota1, nota2, nota3);
        String resultado = resultado(media, frequencia);

        System.out.println("-------------SITUAÇÃO ACADÊMICA---------------");
        System.out.println(   ("Segunda nota: " + nota2);
        System.out.println("Terceira nota: " + nota3);
        System.out.println("Frequência do aluno: " + frequencia + "%");
        System.out.println("Média do aluno: " + String.format("%.2f", media));
        System.out.println("Status: " + resultado);
    }

    public static double resultadoSituacaoAcademica(double nota1, double nota2, double nota3) {
        
        double resultadoMedia = (nota1 + nota2 + nota3) / 3;
        
        return resultadoMedia;
    }

    public static String resultado(double resultadoMedia, double frequencia) {
        
        String resultado;

        if (frequencia < 75) {
            resultado = "Você foi reprovado por frequência";
        } else if (resultadoMedia >= 7) {
            resultado = "Você foi aprovado";
        } else if (resultadoMedia >= 5 && resultadoMedia < 7) {
            resultado = "Você está de recuperação";
        } else {
            resultado = "Você foi reprovado por nota";
        }

        return resultado;
    }
}
