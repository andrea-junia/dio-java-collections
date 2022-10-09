package map;

import java.util.*;


/*
Exercicio 1

Dada a população estimada de alguns estados do NE brasileiro, faça:
    Estado = PE - População = 9.616.621
    Estado = AL - População = 3.351.543
    Estado = CE - População = 9.187.103
    Estado = RN - População = 3.534.265

01) Crie um dicionário e relacione os estados e suas populações;
02) Substitua a população do estado do RN por 3.534.165;
03) Confira se o estado PB está no dicionário, caso não adicione: PB - 4.039.277;
04) Exiba a população PE;
05) Exiba todos os estados e suas populações na ordem que foi  informado;
06) Exiba os estados e suas populações em ordem alfabética;
07) Exiba o estado com o menor população e sua quantidade;
08) Exiba o estado com a maior população e sua quantidade;
09) Exiba a soma da população desses estados;
10) Exiba a média da população deste dicionário de estados;
11) Remova os estados com a população menor que 4.000.000;
12) Apague o dicionário de estados;
13) Confira se o dicionário está vazio.
 */
public class PopulacaoEstimada {

    public static void main(String[] args) {

        System.out.println("01) Crie um dicionário e relacione os estados e suas populações;");
        Map<String, Integer> estadosBR = new HashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estadosBR.toString());
        System.out.println("");

        System.out.println("02) Substitua a população do estado do RN por 3.534.165");
        estadosBR.put("RN", 3534165);
        System.out.println(estadosBR);
        System.out.println("");

        System.out.println("03) Confira se o estado PB está no dicionario, caso nao adicione: PB - 4.039.277");
        if (!estadosBR.containsKey("PB") ){
            estadosBR.put("PB", 4039277);
        }
        System.out.println(estadosBR);
        System.out.println("");

        System.out.println("04) Exiba a populacao PE" + " -> " + estadosBR.get("PE"));
        System.out.println("");

        System.out.println("05) Exiba todos os estados e suas populacoes na ordem que foi informado");
        Map<String, Integer> estados1 = new LinkedHashMap<>() {{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
            put("PB", 4039277);
        }};
        System.out.println(estados1);
        System.out.println("");

        System.out.println("06) Exiba os estados e suas populações em ordem alfabética");
        Map<String, Integer> estados2 = new TreeMap<>(estados1);
        System.out.println(estados2);
        System.out.println("");

        Collection<Integer> populacao = estadosBR.values();
        String maiorPopulacao = "";
        String menorPopulacao = "";
        for (Map.Entry<String, Integer> entry : estadosBR.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) maiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) menorPopulacao = entry.getKey();
        }               
        System.out.println("07) Exiba o estado com o menor população e sua quantidade -> " + menorPopulacao + " - " + Collections.min(populacao));
        System.out.println("");                
        System.out.println("08) Exiba o estado com a maior população e sua quantidade -> " + maiorPopulacao + " - " + Collections.max(populacao));
        System.out.println("");

        int soma = 0;
        Iterator<Integer> iterator1 = estadosBR.values().iterator();
        while (iterator1.hasNext()) {
            soma += iterator1.next();
        }
        System.out.println("09) Exiba a soma da populacao desses estados -> " + soma);

        System.out.println("");

        System.out.println("10) Exiba a média da população deste dicionário de estados -> " + soma/estadosBR.size());
        System.out.println("");

        System.out.println("11) Remova os estados com a população menor que 4.000.000");
        Iterator<Integer> iterator2 = estadosBR.values().iterator();
        while (iterator2.hasNext()) {
            if (iterator2.next() <= 4000000) iterator2.remove();
        }
        System.out.println(estadosBR);
        System.out.println("");

        System.out.println("12) Apague o dicionário de estados");
        estadosBR.clear();
        System.out.println(estadosBR);
        System.out.println("");

        System.out.println("13) Confira se o dicionário está vazio" + estadosBR.isEmpty());        

        System.out.println("");
        System.out.println("");
        System.out.println("FIM!!!");
    }
    
}
