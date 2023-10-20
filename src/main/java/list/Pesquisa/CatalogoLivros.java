package main.java.list.Pesquisa;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class CatalogoLivros {
    private List<Livro> livroList;

    public  CatalogoLivros() {
        this.livroList = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisaPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l : livroList){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    livrosPorAutor.add(l);
                }
            }

        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisaPorIntervaloAnos(int anoInicial, int anoFinal){
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }

    public Livro pesquisaPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()) {
            for (Livro l : livroList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {

        CatalogoLivros catalogoLivros = new CatalogoLivros();

        catalogoLivros.adicionarLivro("O Vendedor de Sonhos", "Augusto Cury", 2008);
        catalogoLivros.adicionarLivro("O Guia Do Mochileiro Das Galaxias", "Douglas Adams", 1979);
        catalogoLivros.adicionarLivro("Os Sete", "André Vianco", 1999);
        catalogoLivros.adicionarLivro("A Batalha do Apocalipse", "Eduardo Spohr", 2007);
        catalogoLivros.adicionarLivro("A Mão Esquerda de Deus", "Paul Hoffman", 2010);

        System.out.println(catalogoLivros.pesquisaPorAutor("Douglas Adams"));
        System.out.println(catalogoLivros.pesquisaPorAutor("Paul Hoffman"));

        System.out.println(catalogoLivros.pesquisaPorTitulo("O Guia Do Mochileiro Das Galaxias"));
        System.out.println(catalogoLivros.pesquisaPorTitulo("O Vendedor de Sonhos"));

        Calendar c = Calendar.getInstance();

        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2000, 2008));
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(1970, 2000));
        System.out.println(catalogoLivros.pesquisaPorIntervaloAnos(2000, c.get(Calendar.YEAR)));
    }
}
