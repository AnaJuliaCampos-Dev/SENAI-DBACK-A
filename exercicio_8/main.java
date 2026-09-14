import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        // Listas paralelas sincronizadas
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();
        
        int escolha = 0;
        
        // Loop principal do menu que executa até o usuário digitar 9
        while (escolha != 9) {
            System.out.println("\n--- GERENCIADOR DE LISTA DE COMPRAS ---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Alterar a quantidade de um produto");
            System.out.println("3 - Alterar o preço do produto");
            System.out.println("4 - Remover um produto");
            System.out.println("5 - Pesquisar produtos pelo nome ou parte dele");
            System.out.println("6 - Listar todos os produtos");
            System.out.println("7 - Calcular o valor total da compra");
            System.out.println("8 - Identificar o produto com maior subtotal");
            System.out.println("9 - Encerrar");
            
            System.out.print("\nEscolha uma opção: ");
            escolha = sc.nextInt();
            
            // Validação das opções do menu
            if (escolha < 1 || escolha > 9) {
                System.out.println("Digite somente números entre 1 e 9.");
            } else if (escolha == 9) {
                System.out.println("Encerrando o programa...");
            } else {
                // Direciona a execução para a função correspondente
                switch (escolha) {
                    case 1:
                        adicionarProduto(sc, nomes, quantidades, precos);
                        break;
                    case 2:
                        alterarQuantidade(sc, nomes, quantidades, precos);
                        break;
                    case 3:
                        alterarPreco(sc, nomes, quantidades, precos);
                        break;
                    case 4:
                        removerProduto(sc, nomes, quantidades, precos);
                        break;
                    case 5:
                        pesquisarProduto(sc, nomes, quantidades, precos);
                        break;
                    case 6:
                        listarProdutos(nomes, quantidades, precos);
                        break;
                    case 7:
                        calcularTotal(nomes, quantidades, precos);
                        break;
                    case 8:
                        maiorSubtotal(nomes, quantidades, precos);
                        break;
                }
            }
        }
    }

    // MÉTODO DE ADICIONAR PRODUTOS
    public static void adicionarProduto(Scanner sc, ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        sc.nextLine(); // Limpa o buffer do teclado

        System.out.print("\nNome do produto: ");
        String nome = sc.nextLine();

        // Verifica se o produto já existe
        int indiceExistente = -1;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nome)) {
                indiceExistente = i;
                break;
            }
        }

        // Le e valida a quantidade
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        if (quantidade <= 0) {
            System.out.println("Erro: A quantidade deve ser maior que zero.");
            return;
        }

        // Verifica se o produto existe para acrecentar a quantidade
        if (indiceExistente != -1) {
            System.out.println("Esse produto já existe na lista.");
            System.out.print("Deseja somar essa quantidade ao produto existente? (1 - Sim / 2 - Não): ");
            int resposta = sc.nextInt();
            
            if (resposta == 1) {
                int qtdAtual = quantidades.get(indiceExistente);
                quantidades.set(indiceExistente, qtdAtual + quantidade);
                System.out.println("Quantidade atualizada.");
            } else {
                System.out.println("Operação cancelada.");
            }
            return;
        }

        // Leitura e validação do preço para produtos novos
        System.out.print("Preço unitário: R$ ");
        double preco = sc.nextDouble();
        
        if (preco <= 0) {
            System.out.println("Erro: O preço deve ser maior que zero.");
            return;
        }

        // Adiciona o novo produto mantendo os índices alinhados
        nomes.add(nome);
        quantidades.add(quantidade);
        precos.add(preco);

        System.out.println("Produto cadastrado.");
    }

    // MÉTODO ALTERAR QUANTIDADE
    public static void alterarQuantidade(Scanner sc, ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia");
            return;
        }

        sc.nextLine(); // Limpa o buffer
        System.out.print("\nDigite o nome do produto: ");
        String nomeBusca = sc.nextLine();

        // Procura a posição do produto
        int indice = -1;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nomeBusca)) {
                indice = i;
                break;
            }
        }

        // Atualiza a quantidade no índice
        if (indice != -1) {
            System.out.print("Digite a nova quantidade para " + nomes.get(indice) + ": ");
            int novaQtd = sc.nextInt();

            if (novaQtd > 0) {
                quantidades.set(indice, novaQtd);
                System.out.println("Quantidade atualizada.");
            } else {
                System.out.println("Erro: A quantidade deve ser maior que zero.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // MÉTODO ALTERAR PREÇO
    public static void alterarPreco(Scanner sc, ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia.");
            return;
        }

        sc.nextLine(); // Limpa o buffer
        System.out.print("\nDigite o nome do produto: ");
        String nomeBusca = sc.nextLine();

        // Procura a posição do produto
        int indice = -1;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nomeBusca)) {
                indice = i;
                break;
            }
        }

        // Atualiza o preço no índice
        if (indice != -1) {
            System.out.print("Digite o novo preço para " + nomes.get(indice) + ": R$ ");
            double novoPreco = sc.nextDouble();

            if (novoPreco > 0) {
                precos.set(indice, novoPreco);
                System.out.println("Preço atualizado.");
            } else {
                System.out.println("Erro: O preço deve ser maior que zero.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    // MÉTODO REMOVER PRODUTO
    public static void removerProduto(Scanner sc, ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia.");
            return;
        }

        sc.nextLine(); // Limpa o buffer
        System.out.print("\nDigite o nome do produto que deseja remover: ");
        String nomeBusca = sc.nextLine();

        int indice = -1;
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).equalsIgnoreCase(nomeBusca)) {
                indice = i;
                break;
            }
        }

        // Romoção da três listas
        if (indice != -1) {
            nomes.remove(indice);
            quantidades.remove(indice);
            precos.remove(indice);
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    //MÉTODO PESQUISAR PRODUTO
    public static void pesquisarProduto(Scanner sc, ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia");
            return;
        }

        sc.nextLine(); // Limpa o buffer
        System.out.print("\nDigite o nome ou parte do nome do produto: ");
        String termo = sc.nextLine().toLowerCase();

        boolean encontrou = false;
        System.out.println("\n--- Resultado da Busca ---");
        
        // Percorre a lista verificando se o termo digitado está contido no nome
        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).toLowerCase().contains(termo)) {
                double subtotal = quantidades.get(i) * precos.get(i);
                System.out.println("Produto: " + nomes.get(i) + " | Quantidade: " + quantidades.get(i) + " | Preço: R$ " + precos.get(i) + " | Subtotal: R$ " + subtotal);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum produto encontrado com o dados informado.");
        }
    }

    //MÉTODO LISTAR PRODUTOS
    public static void listarProdutos(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia.");
            return;
        }

        System.out.println("\n--- Lista de Compras ---");
        // Loop para calcular  e exebir o subtotal de cada posição
        for (int i = 0; i < nomes.size(); i++) {
            double subtotal = quantidades.get(i) * precos.get(i);
            System.out.println((i + 1) + " Produto: " + nomes.get(i) + " | Quantidade: " + quantidades.get(i) + " | Preço: R$ " + precos.get(i) + " | Subtotal: R$ " + subtotal);
        }
    }

    //MÉTODO CALCULAR TOTAL
    public static void calcularTotal(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia.");
            return;
        }

        // Acumulação do subtotal de cada item no total geral
        double totalGeral = 0;
        for (int i = 0; i < nomes.size(); i++) {
            totalGeral += quantidades.get(i) * precos.get(i);
        }

        System.out.println("\nValor total estimado da compra: R$ " + totalGeral);
    }

    //MÉTODO PRODUTO COM MAIOR SUBTOTAL
    public static void maiorSubtotal(ArrayList<String> nomes, ArrayList<Integer> quantidades, ArrayList<Double> precos) {
        if (nomes.isEmpty()) {
            System.out.println("\nA lista de compras está vazia.");
            return;
        }

        // Indica que o primeiro item da lista é o maior valor
        int indiceMaior = 0;
        double maiorValor = quantidades.get(0) * precos.get(0);

        // Compara com os itens restantes da lista
        for (int i = 1; i < nomes.size(); i++) {
            double subtotalAtual = quantidades.get(i) * precos.get(i);
            if (subtotalAtual > maiorValor) {
                maiorValor = subtotalAtual;
                indiceMaior = i;
            }
        }

        System.out.println("\n--- Produto com maior subtotal ---");
        System.out.println("Produto: " + nomes.get(indiceMaior));
        System.out.println("Quantidade: " + quantidades.get(indiceMaior));
        System.out.println("Preço Unitário: R$ " + precos.get(indiceMaior));
        System.out.println("Subtotal: R$ " + maiorValor);
    }
}
