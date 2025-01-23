
package atv5;


public class Bebida extends ItemCardapio {
    
    private double quantidade;

    public Bebida(String nome,int quantidade,  double preco) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    public double getQuantidade() {
        return quantidade;
    }
  
   
    @Override
    public void imprimirDados() {
        super.imprimirDados();
        System.out.println("Quantidade: " + quantidade + " ml");
    
    
}
}
