import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        //Apresentação e entradas de dados
        Scanner sc = new Scanner(System.in);
        System.out.println("---VALIDAÇÃO E ANÁLISE DE UMA DATA---");
        System.out.print("Escreva o dia do mês: ");
        int dia = sc.nextInt();
        
        System.out.print("Escreva o mês (por numerico): ");
        int mes = sc.nextInt();
        
        System.out.print("Escreva o ano: ");
        int ano = sc.nextInt();
        sc.nextLine();
        
        System.out.println("---------------------------");
        
        if (validarData(dia,mes,ano)){
            System.out.println("Trimestre: " + trimestre(mes) + "º");
            System.out.println("Dia do Ano: " + posicaoAno(dia, mes, ano) + "º dia");
        } else {
            System.out.println("Data Inválida");
        }
        
    }
    
    //MÉTODO PARA VERIFICAR SE É ANO BISSEXTO
    public static boolean bissexto (int ano) {
        
        //Método para calcular se o ano é bissexto ou não
        //Pço para retorna duas condições
        //Verifico se o ano é divisivel por 4 (ano % 4 == 0)
        //Verifico se ele também não é divisivel por 100 (ano % 100 ! = 0)
        //Uso uma segunda condição para averiguar se o ano é divisivel por 400 (ano % 400 == 0 - Uso para anos de fim de séculos)
       return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
    
    //MÉTODO PARA VERIFICAR QUANTOS DIAS TEM NO MÊS
    public static int diasNoMes (int mes, int ano) {
        
        //Analisa os dias que tera os meses
        if (mes == 2) {
            if (bissexto(ano)) {
                return 29; //se for ano bissexto, terá 29 dias
            } else {
                return 28; //se não for ano bissexto, será 28 dias
            }
        } else if (mes==4 || mes==6 || mes==9 || mes==11) {
            return 30; //Testa para verificar se for meses de 30 dias (4,5,9 e 11)
        } else if (mes == 1 || mes ==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) {
            return 31; //Se for os meses 1,3,5,7,8,10 e 12, terá 31 dias
        } else {
            return 0; //Se for inserido um mês invalido, retornará 0 no final
        }
        
    }
    
    //MÉTODO PARA VALIDAR A DATA
    public static boolean validarData (int dia, int mes, int ano) {
        
        //Se o ano for positivo, mes for de 1 a 12, e o dia ser até a quntidade disas do mês, a data é valida
        if (ano>0 && mes>=1 && mes<=12 && dia>=1 && dia <= diasNoMes(mes,ano)) {
            return true;
        } else {
            return false;
        }
    }
    
    //MÉTODO PARA VEIRIFCAR O TRIMESTRE DA DATA
    public static int trimestre (int mes) {
        
        
        if (mes>= 1 && mes<=3) {
            return 1; // Verifica se são os meses 1,2 e 3 para retornar o primeiro trimestre
        } else if (mes>= 4 && mes<=6) {
            return 2; // Verifica se são os meses 4,5 e 6 para retornar o segundo trimestre
        } else if (mes>= 7 && mes<=9) {
            return 3; // Verifica se são os meses 7,8 e 9 para retornar o terceiro trimestre
        }else if (mes>= 10 && mes<=12) {
            return 4; // Verifica se são os meses 10, 11 e 12 para retornar o quarto trimestre
        } else {
            return 0; //Se for inserido um mês invalido, retornará 0 no final
        }
        
    }
    
    //MÉTODO PARA VEIRIFCAR O DIA DO ANO
    public static int posicaoAno (int dia, int mes, int ano){
        
        //Soma os dias dos meses que já se passaram e adiciona os dias do mês atual
        int soma = 0;
        for (int i = 1; i < mes; i++) {
            soma+=diasNoMes(i, ano);
        }
        
        return soma + dia;
    }
}