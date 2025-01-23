
package atv5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ATV5 {

    
    public static void main(String[] args) {
        
        
        Scanner entrada = new Scanner(System.in);
        Cardapio cardapio = new Cardapio("PizzaTop");

        while (true) {
            System.out.println("\n Menu");
            System.out.println("1.Cadastrar  pizza no cardápio");
            System.out.println("2.Cadastrar  bebida no cardápio");
            System.out.println("3.Mostrar cardápio");
            System.out.println("4.Criar pedido e mostrar dados do pedido");
            System.out.println("5.Cadastrar pedido para a cozinha");
            System.out.println("6.Extrair próximo pedido a ser preparado e levado ao cliente");
            System.out.println("7. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    cadastrarPizza(cardapio);
                    break;
                case 2:
                    cadastrarBebida(cardapio);
                    break;
                case 3:
                    cardapio.imprimirCardapio();
                    break;
                case 4:
                    criarPedido(entrada, cardapio);
                    break;
                case 5:
                    cadastrarPedido(entrada);
                    break;
                case 6:
                    extrairProximoPedido();
                    break;
                case 7:
                    System.out.println("Saindo do Sistema!!");
                    entrada.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarPizza(Cardapio cardapio) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\nCadastro de Pizza");
        System.out.print("Nome da Pizza: ");
        String nome = entrada.nextLine();
        System.out.print("Tamanho (em cm): ");
        int tamanho = entrada.nextInt();
        System.out.print("Preço: ");
        double preco = entrada.nextDouble();
        System.out.print("Sabor (D para Doce / S para Salgada): ");
        char sabor = entrada.next().charAt(0);
        System.out.print("Quantidade de Ingredientes: ");
        int quantidadeIngredientes = entrada.nextInt();

        entrada.nextLine(); 
        List<String> ingredientes = new ArrayList<>();
        for (int i = 1; i <= quantidadeIngredientes; i++) {
            System.out.print("Ingrediente " + i + ": ");
            ingredientes.add(entrada.nextLine());
        }

        Pizza novaPizza = new Pizza(nome, tamanho, preco, sabor, ingredientes);
        cardapio.adicionarItemCardapio(novaPizza);
        System.out.println("Pizza cadastrada com sucesso!");
    }

    private static void cadastrarBebida(Cardapio cardapio) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\n Cadastro de Bebida ");
        System.out.print("Nome da Bebida: ");
        String nome = entrada.nextLine();
        System.out.print("Quantidade (em ml): ");
        int quantidade = entrada.nextInt();
        System.out.print("Preço: ");
        double preco = entrada.nextDouble();

        Bebida novaBebida = new Bebida(nome, quantidade, preco);
        cardapio.adicionarItemCardapio(novaBebida);
        System.out.println("Bebida cadastrada com sucesso!");
    }

    private static void criarPedido(Scanner entrada, Cardapio cardapio) {
        System.out.println("\nCriação de Pedido");
        System.out.print("Número da Mesa: ");
        int numeroMesa = entrada.nextInt();

        Pedido novoPedido = new Pedido(numeroMesa);

        boolean continuarAdicionando = true;
        while (continuarAdicionando) {
            System.out.println("\n=== Adicionar ao Pedido ===");
            System.out.println("1. Adicionar Pizza");
            System.out.println("2. Adicionar Bebida");
            System.out.println("3. Finalizar Pedido");

            System.out.print("Escolha uma opção: ");
            int escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    adicionarPizzaAoPedido(entrada, cardapio, novoPedido);
                    break;
                case 2:
                    adicionarBebidaAoPedido(entrada, cardapio, novoPedido);
                    break;
                case 3:
                    continuarAdicionando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        novoPedido.mostrarDados();
    }

    private static void adicionarPizzaAoPedido(Scanner entrada, Cardapio cardapio, Pedido pedido) {
        cardapio.imprimirCardapio();
    System.out.print("Escolha o número da pizza: ");
    int numeroPizza = entrada.nextInt();

    List<ItemCardapio> itensCardapio = cardapio.getItensCardapio();
    if (numeroPizza >= 1 && numeroPizza <= itensCardapio.size()) {
        ItemCardapio itemEscolhido = itensCardapio.get(numeroPizza - 1);
        if (itemEscolhido instanceof Pizza) {
            Pizza pizzaEscolhida = (Pizza) itemEscolhido;
            pedido.adicionarPizza(pizzaEscolhida);
            System.out.println("Pizza adicionada ao pedido.");
        } else {
            System.out.println("Escolha inválida. O item selecionado não é uma pizza.");
        }
    } else {
        System.out.println("Número de pizza inválido. Tente novamente.");
    }
}
    

    private static void adicionarBebidaAoPedido(Scanner entrada, Cardapio cardapio, Pedido pedido) {
        cardapio.imprimirCardapio();
        System.out.print("Escolha o número da bebida: ");
        int numeroBebida = entrada.nextInt();

        Bebida bebidaEscolhida = cardapio.getBebidas().get(numeroBebida - 1);
        pedido.adicionarBebida(bebidaEscolhida);
        System.out.println("Bebida adicionada ao pedido.");
    }

    private static void cadastrarPedido(Scanner entrada) {
        
        System.out.println("Pedido cadastrado para a cozinha.");
    }

    private static void extrairProximoPedido() {
       
        System.out.println("Próximo pedido preparado e pronto para ser levado ao cliente.");
    }
}
        
        
        
        
    
    

