
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
    
    static int[] indicePluviometricoDiario;
    
    static int indicePluviometricoTotal;
    
    static float indicePluviometricoMedio, indicePluviometricoMaximo;
    
    static Scanner input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
        indicePluviometricoDiario = new int[31];
        
        for (int diaDeOcorrencia = 0; diaDeOcorrencia < 31; diaDeOcorrencia++){
            System.out.println("Digite o indice pluviometrico do dia " + (diaDeOcorrencia+1) + ": ");
            indicePluviometricoDiario[diaDeOcorrencia] = input.nextInt();
            if(diaDeOcorrencia == 0){
                indicePluviometricoMaximo = indicePluviometricoDiario[diaDeOcorrencia];
            }
            if(indicePluviometricoDiario[diaDeOcorrencia] > indicePluviometricoMaximo){
                indicePluviometricoMaximo = indicePluviometricoDiario[diaDeOcorrencia];
            }
            indicePluviometricoTotal += indicePluviometricoDiario[diaDeOcorrencia];
        }
        
        indicePluviometricoMedio = indicePluviometricoTotal / indicePluviometricoDiario.length;
        
        System.out.println("\nO indice pluviometrico médio é: " + indicePluviometricoMedio);
        System.out.println("O indice pluviometrico máximo é: " + indicePluviometricoMaximo);
        
    }
    
}
