
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
    
    static private int base, altura;
    static private Scanner input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
        
        System.out.println("Digite a base: ");
        base = input.nextInt();
        System.out.println("Digite a altura: ");
        altura = input.nextInt();
        
        int area = base * altura;
        int perimetro = (base*2) + (altura*2);
        
        System.out.println("A area é: " + area);
        System.out.println("O perímetro: " + perimetro);
        
    }
    
}
