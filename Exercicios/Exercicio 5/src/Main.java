
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
    
    static int codigoOperacao;
    static float num1, num2;
    static Scanner input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
        
        System.out.println("Digite o numero 1: ");
        num1 = input.nextFloat();
        System.out.println("Digite o numero 2: ");
        num2 = input.nextFloat();
        
        System.out.println("Digite o codigo da operacao desejada: ");
        codigoOperacao = input.nextInt();
        
        switch(codigoOperacao){
            case 1:
                System.out.println("Media de " + num1 + " e " + num2 + " é: " + ((num1 + num2) / 2));
                break;
            case 2:
                if(num1 > num2){
                    System.out.println("Subtracao de " + num1 + " e " + num2 + " é " + (num1 - num2));
                } else {
                    System.out.println("Invalido");
                }
                break;
            case 3:
                System.out.println("Multiplicacao de " + num1 + " e " + num2 + " é " + (num1 * num2));
                break;
            case 4:
                if(num1 > num2){
                    System.out.println("Divisao de " + num1 + " e " + num2 + " é " + (num1 / num2)); 
                } else {
                    System.out.println("Invalido");
                }
                break;
            case 5:
                System.out.println("Operacao Inválida");
                break;
        }
    }
    
}
