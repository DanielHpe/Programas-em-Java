package projeto.pkg2;

import java.util.Scanner;

public class Menu {
    
    int opcao;  
    Scanner input = new Scanner(System.in);
    
    public int menu(){
        System.out.println("\nCalculadora");
        System.out.println("1 - Somar");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.printf("Digite a opção desejada: ");
        opcao = input.nextInt();
        
        return opcao;
    }    
}
