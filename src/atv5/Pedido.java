
package atv5;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    
    private int numeroMesa;
    private List<ItemCardapio> itensPedido;

    public Pedido(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.itensPedido = new ArrayList<>();
    }
    
     public void adicionarPizza(Pizza pizza) {
        itensPedido.add(pizza);
    }
     public void adicionarBebida(Bebida bebida) {
        itensPedido.add(bebida);
    }
    
    public void  adicionarItemAoPedido(ItemCardapio item) {
        itensPedido.add(item);
    }

  
    
    public double calcularTotal() {
        
        double total = 0;
        for (ItemCardapio item : itensPedido) {
            total += item.getPreco();
        }
        return total;
    }
    
    public void mostrarDados() {
        System.out.println("Pedido para Mesa " + numeroMesa);
        for (ItemCardapio item : itensPedido) {
            if (item instanceof Pizza) {
                ((Pizza) item).imprimirDados();
            } else if (item instanceof Bebida) {
                ((Bebida) item).imprimirDados();
            }
           
        }
        System.out.println("Total do Pedido: R$" +  calcularTotal());
    }
    
  
    
    
}
