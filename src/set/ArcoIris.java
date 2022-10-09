package set;

import java.util.*;

/*
Crie uma conjunto contendo as cores do arco-íris e:
a) Exiba todas as cores o arco-íris uma abaixo da outra;
b) A quantidade de cores que o arco-íris tem;
c) Exiba as cores em ordem alfabética;
d) Exiba as cores na ordem inversa da que foi informada;
e) Exiba todas as cores que começam com a letra ”v”;
f) Remova todas as cores que não começam com a letra “v”;
g) Limpe o conjunto;
h) Confira se o conjunto está vazio;
 */

public class ArcoIris {
    public static void main(String[] args) {
        //Crie uma conjunto contendo as cores do arco-íris
        Set<String> listArcoIris = new HashSet<>();
        listArcoIris.add("vermelho");
        listArcoIris.add("laranja");
        listArcoIris.add("amarelo");
        listArcoIris.add("verde");        
        listArcoIris.add("azul");
        listArcoIris.add("anil");        
        listArcoIris.add("violeta");        
        System.out.println("Exercicio 1 - Arco Iris\n");
        System.out.println("a) Exiba todas as cores o arco-íris uma abaixo da outra");
        for (String cor : listArcoIris) System.out.println(cor);

        System.out.println();
        System.out.println("b) A quantidade de cores que o arco-íris tem");
        System.out.println(listArcoIris.size());

        System.out.println();
        System.out.println("c) Exiba as cores em ordem alfabética");        
        Set<String> listOrdemAlfabetica = new TreeSet<>(listArcoIris);
        for (String cor : listOrdemAlfabetica) System.out.println(cor);

        System.out.println();
        System.out.println("d) Exiba as cores na ordem inversa da que foi informada");
        Set<String> listaInversa = new LinkedHashSet<>(listArcoIris);
        List<String> coresInversas = new ArrayList<>(listaInversa);
        Collections.reverse(coresInversas);
        for (String cor : coresInversas) System.out.println(cor);

        System.out.println();
        System.out.println("e) Exiba todas as cores que começam com a letra 'v'");
        String str = "";
        for (String cor : listArcoIris){
            str = cor;
            if ((str.substring(0,1).equals("v"))){
                System.out.println(cor);                
            }           
        }      

        System.out.println();
        System.out.println("f) Remova todas as cores que nao começam com a letra 'v'");
        Iterator<String> iterator = listArcoIris.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().startsWith("v")) iterator.remove();
        }
        for (String cor : listArcoIris) System.out.println(cor);

        System.out.println();
        System.out.println("g) Limpe o conjunto");
        listArcoIris.clear();

        System.out.println();
        System.out.println("h) Confira se o conjunto está vazio");
        if(listArcoIris.isEmpty()) System.out.println("Lista vazia");

        System.out.println();
        System.out.println("FIM!");
        

    }
}

