package atv5;

public class ItemCardapio {

    private String nome;
    private double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void imprimirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Preço: R$" + preco);
    }

}
