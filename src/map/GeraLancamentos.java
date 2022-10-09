package map;
import java.util.*;

/*
Exercicio 2

Faça um programa que simule um lançamento de dados.
Lance o dado 100 vezes e armazene.
Depois, mostre quantas vezes cada valor foi inserido.
 */

public class GeraLancamentos {
    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        Random lancamentoAleatorio = new Random();
        for (int i = 0; i < 100; i++) {
            int number = lancamentoAleatorio.nextInt(10) + 1;
            lista.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : lista) {
            if (lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }
        
        System.out.println("\nVl         " + " Qtd");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }

}
