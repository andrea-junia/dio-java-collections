package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

class TemperaturaMedia{
    /**
     * @param args
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Double media = 0.0d;
        boolean lAcima = false;

        List<Meses> meses = new ArrayList<>(){{
            add(new Meses("Janeiro", 0.0d));
            add(new Meses("Fevereiro", 0.0d));
            add(new Meses("Marco", 0.0d));
            add(new Meses("Abril", 0.0d));
            add(new Meses("Maio", 0.0d));
            add(new Meses("Junho", 0.0d));
        }};

        System.out.println("EXERCICIO 1 - TEMPERATURA MESES");
        System.out.println();

        for (Meses mes : meses) {
            System.out.print(mes.getMes() + ": ");
            mes.setTemperatura(teclado.nextDouble()); 
            media += mes.getTemperatura();           
        }
        media = media/6;

        System.out.println();
        System.out.println("TEMPERATURAS CADASTRADAS");        
        for (Meses mes : meses) System.out.println(mes.getMes() + ": " + mes.getTemperatura());      
        System.out.println();
        System.out.printf("Media -> %.2f\n", media);

        System.out.println("Meses com temperatura acima da média ");

        for (Meses mes : meses) {
            if(Double.compare(media, mes.getTemperatura()) < 0 ){
                System.out.println(mes.getMes()+" -> " + mes.getTemperatura());
                lAcima = true;
            }                   
        }

        if (!lAcima) System.out.println("Nao houve mes com temperatura acima da media.");

        System.out.println();    
        System.out.println("FIM!");
    
        teclado.close();

    }
}

class Meses {
    private String descricao;
    private Double temperatura;

    public Meses(String descricao, Double temperatura){
        this.descricao = descricao;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return descricao;
    }

    public void setMes(String descricao) {
        this.descricao = descricao;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return "{descricao=" + descricao + ", temperatura=" + temperatura + "}";
    }  
}

