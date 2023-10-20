package main.java.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();
        if(!itemList.isEmpty()){
            for(Item i : itemList) {
                if(i.getNome().equalsIgnoreCase(nome)) {
                    itemsParaRemover.add(i);
                }
            }
            itemList.removeAll(itemsParaRemover);
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for(Item i : itemList){
            valorTotal += i.getPreco() * i.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens(){
        System.out.println(itemList);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras itemList = new CarrinhoDeCompras();

        itemList.adicionarItem("Nescau", 5.25, 2);

        System.out.println(itemList.calcularValorTotal());

        itemList.adicionarItem("Cereal", 10.50, 1);

        System.out.println(itemList.calcularValorTotal());

        itemList.exibirItens();
    }

}
