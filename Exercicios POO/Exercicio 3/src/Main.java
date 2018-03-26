
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
    
    static float altura, peso, imc;
    static Scanner input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
        
        System.out.println("Digite seu peso: ");
        peso = input.nextFloat();
        System.out.println("Digite a sua altura: (em metros) ");
        altura = input.nextFloat();
        
        imc = peso / (altura * altura);
        
        if(imc < 18.5){
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.5 && imc < 25){
            System.out.println("Peso normal");
        } else if (imc >= 25 && imc < 30){
            System.out.println("Acima do peso");
        } else if(imc >= 30){
            System.out.println("Obeso");
        }
    }
    
}
