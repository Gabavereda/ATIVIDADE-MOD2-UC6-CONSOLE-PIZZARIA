package atv5;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {

    private String nomePizzaria;
    private List<ItemCardapio> itensCardapio;
    private List<Bebida> bebidas;

    public Cardapio(String nomePizzaria) {
        this.nomePizzaria = nomePizzaria;

        this.itensCardapio = new ArrayList<>();
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public String getNomePizzaria() {
        return nomePizzaria;
    }

    public void setNomePizzaria(String nomePizzaria) {
        this.nomePizzaria = nomePizzaria;
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void adicionarItemCardapio(ItemCardapio item) {
        itensCardapio.add(item);
    }

    public void imprimirCardapio() {
        System.out.println("=== Cardápio da Pizzaria " + nomePizzaria + " ===");
        System.out.println("Pizzas:");
        for (ItemCardapio item : itensCardapio) {
            if (item instanceof Pizza) {
                item.imprimirDados();
                System.out.println("----------------------");
            }
        }

        System.out.println("Bebidas:");
        for (ItemCardapio item : itensCardapio) {
            if (item instanceof Bebida) {
                item.imprimirDados();
                System.out.println("----------------------");
            }
        }
    }

}
