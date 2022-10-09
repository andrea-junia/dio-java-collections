package set;

import java.util.*;

/*
Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
Em seguida, crie um conjunto com 3 linguagens e faça um programa que ordene esse conjunto por:
a) Ordem de inserção;
b) Ordem natural(nome);
c) IDE;
d) Ano de criação e nome;
e) Nome, ano de criação e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
 */

public class LinguagemPreferida {
    public static void main(String[] args) {

        //crie um conjunto com 3 linguagens 
        Set<Linguagem> LinguagensFavoritas = new HashSet<>();
        LinguagensFavoritas.add(new Linguagem("JavaScript", 1991, "VSCode"));
        LinguagensFavoritas.add(new Linguagem("Java", 1991, "IntelliJ"));
        LinguagensFavoritas.add(new Linguagem("SQL", 1982, "Toad"));

        System.out.println("a) Ordem de inserção");
        Set<Linguagem> lggFavoritas1 = new LinkedHashSet<>(
                Arrays.asList(
                        new Linguagem("JavaScript", 1991, "VSCode"),
                        new Linguagem("Java", 1991, "IntelliJ"),
                        new Linguagem("SQL", 1982, "Toad")
                )
        );
        for (Linguagem linguagem : lggFavoritas1) System.out.println(linguagem);
        System.out.println("");

        System.out.println("b) Ordem natural(nome)");   
        Set<Linguagem> lggFavoritas2 = new TreeSet<Linguagem>(new ComparaNome());
        lggFavoritas2.addAll(LinguagensFavoritas);
        for (Linguagem linguagem : lggFavoritas2) {
            System.out.println(linguagem.getNome() + " -> " + linguagem.getAnoDeCriacao() + " -> " + linguagem.getIde()); 
        } 
        System.out.println("");

        System.out.println("c) IDE"); 
        Set<Linguagem> lggFavoritas3 = new TreeSet<Linguagem>(new ComparaIde());
        lggFavoritas3.addAll(LinguagensFavoritas);
        for (Linguagem linguagem : lggFavoritas3) {
            System.out.println(linguagem.getNome() + " -> " + linguagem.getAnoDeCriacao() + " -> " + linguagem.getIde()); 
        } 
        System.out.println("");

        System.out.println("d) Ano de criacao e nome");
        Set<Linguagem> lggFavoritas4 = new TreeSet<Linguagem>(new ComparaAnoNome());
        lggFavoritas4.addAll(LinguagensFavoritas);
        for (Linguagem linguagem : lggFavoritas4) {
            System.out.println(linguagem.getNome() + " -> " + linguagem.getAnoDeCriacao() + " -> " + linguagem.getIde()); 
        } 
        System.out.println("");

        System.out.println("e) Nome, ano de criacao e IDE");
        Set<Linguagem> lggFavoritas5 = new TreeSet<Linguagem>(new ComparaAnoNome());
        lggFavoritas5.addAll(LinguagensFavoritas);
        for (Linguagem linguagem : lggFavoritas5) {
            System.out.println(linguagem.getNome() + " -> " + linguagem.getAnoDeCriacao() + " -> " + linguagem.getIde()); 
        } 

        System.out.println("");

        System.out.println("Ao final, exiba as linguagens no console, um abaixo da outra");
        for (Linguagem linguagem : lggFavoritas4) {
            System.out.println(linguagem.getNome() + " -> " + linguagem.getAnoDeCriacao() + " -> " + linguagem.getIde()); 
        } 

        System.out.println("");
        System.out.println("");
        System.out.println("FIM!!");


    }
}

//Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao e IDE.
class Linguagem implements Comparable<Linguagem>{
    public String nome;
    public Integer anoDeCriacao;
    public String ide;  
    
    public Linguagem(String nome, Integer anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoDeCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(Integer anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "[nome=" + nome + ", anoDeCriacao=" + anoDeCriacao + ", ide=" + ide + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((anoDeCriacao == null) ? 0 : anoDeCriacao.hashCode());
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Linguagem other = (Linguagem) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (anoDeCriacao == null) {
            if (other.anoDeCriacao != null)
                return false;
        } else if (!anoDeCriacao.equals(other.anoDeCriacao))
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        return true;
    }

    @Override
    public int compareTo(Linguagem lgg) {
        return 0;
    }

}

class ComparaNome implements Comparator<Linguagem>{

    @Override
    public int compare(Linguagem lgg1, Linguagem lgg2) {

        return lgg1.nome.compareToIgnoreCase(lgg2.nome);
    }
}

class ComparaIde implements Comparator<Linguagem>{

    @Override
    public int compare(Linguagem lgg1, Linguagem lgg2) {

        return lgg1.ide.compareToIgnoreCase(lgg2.ide);
    }
}

class ComparaAnoNome implements Comparator<Linguagem>{

    @Override
    public int compare(Linguagem lgg1, Linguagem lgg2) {
        
        int anoDeCriacao = Integer.compare(lgg1.anoDeCriacao, lgg2.anoDeCriacao);
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lgg1.nome.compareToIgnoreCase(lgg2.nome);
    }
}

class ComparaNomeAnoIde implements Comparator<Linguagem>{

    @Override    
    public int compare(Linguagem lgg1, Linguagem lgg2) {
        int nome = lgg1.nome.compareToIgnoreCase(lgg2.nome);
        int anoDeCriacao = Integer.compare(lgg1.anoDeCriacao, lgg2.anoDeCriacao);
        if (nome != 0) return nome;
        if (anoDeCriacao != 0) return anoDeCriacao;
        return lgg1.ide.compareToIgnoreCase(lgg2.ide);
    }
}


