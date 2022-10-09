package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Utilizando listas, faça um programa que faça 5 perguntas para uma pessoa sobre um crime. As perguntas são:
1. "Telefonou para a vítima?"
2. "Esteve no local do crime?"
3. "Mora perto da vítima?"
4. "Devia para a vítima?"
5. "Já trabalhou com a vítima?"
Se a pessoa responder positivamente a 2 questões ela deve ser classificada como "Suspeita", entre 3 e 4 como
"Cúmplice" e 5 como "Assassina". Caso contrário, ele será classificado como "Inocente".
*/

public class EhInocente {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int nrRespostas = 0;
        String resposta = "";
        boolean lResposta = true;

        List<String> perguntas = new ArrayList<>();
        perguntas.add("Telefonou para a vítima? ");
        perguntas.add("Esteve no local do crime? ");
        perguntas.add("Mora perto da vítima? ");
        perguntas.add("Devia para a vítima? ");
        perguntas.add("Já trabalhou com a vítima? ");

        System.out.println("RESPONDA SIM OU NAO PARA AS PERGUNTAS ABAIXO");

        for (String pergunta : perguntas){
            
            System.out.print(pergunta);
            resposta = teclado.next();
            lResposta = (resposta.toUpperCase().equals("SIM")) || (resposta.toUpperCase().equals("NAO"));

            while(!lResposta){
                System.out.print("Responda com Sim ou Nao. " + pergunta);
                resposta = teclado.next();  
                lResposta = (resposta.toUpperCase().equals("SIM")) || (resposta.toUpperCase().equals("NAO"));
            };
                     
            if (resposta.toUpperCase().equals("SIM")) nrRespostas++;
        }

        switch(nrRespostas) {
            case 2:
                System.out.println(">> SUSPEITA <<"); break;
            case 3:
            case 4:
                System.out.println(">> CÚMPLICE <<"); break;
            case 5:
                System.out.println(">> ASSASSINO <<"); break;
            default:
                System.out.println(">> INOCENTE <<"); break;
        }
        
        System.out.println();    
        System.out.println("FIM!");
    
        teclado.close();
    }
    
}
