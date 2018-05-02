
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static float massa, pesoFinal, massaInicial;
    static Scanner input;
    static int tempo;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
        
        System.out.println("Digite a massa do material (gramas): ");
        massa = input.nextFloat();
        
        massaInicial = massa;
        
        while(massa > 0.5){
            massa = massa/2;
            tempo += 50;
        }
        
        float tempoMinutos = tempo/60;
        
        System.out.println("Tempo necessário para massa menor que 0.5 é: " + tempo + " segundos(" + tempoMinutos + " minutos)");
        System.out.println("A massa final é: " + massa);
        System.out.println("A massa inicial é: " + massaInicial);
        System.out.println("");
        
    }
    
}
