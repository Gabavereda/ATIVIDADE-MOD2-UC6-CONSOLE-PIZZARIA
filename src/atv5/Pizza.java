package atv5;

import java.util.List;

public class Pizza extends ItemCardapio{
    
   
    private int tamanho;
 
    private char sabor; // 'D'= doce , 'S' = Salgada
    private List<String> ingredientes;

    public Pizza(String nome, int tamanho, double preco, char sabor, List<String> ingredientes) {
        super(nome, preco);
        this.tamanho = tamanho;
        this.sabor = sabor;
        this.ingredientes = ingredientes;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Tamanho: " + tamanho + " cm");        
        System.out.println("Sabor: " + (sabor == 'D' ? "Doce" : "Salgada"));
        System.out.println("Ingredientes:");
        for (String ingrediente : ingredientes) {
            System.out.println(" - " + ingrediente);
        }
    }
}

 