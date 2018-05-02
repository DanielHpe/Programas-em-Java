
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
public class Menu {
    
    int opcao;
    Scanner input = new Scanner(System.in);
    
    public int mostrarMenu(){
        System.out.println("\nMenu ");
        System.out.println("\n1 - Novo Salario");
        System.out.println("2 - Ferias");
        System.out.println("3 - Decimo Terceiro");
        System.out.println("4 - Sair");
        System.out.println("\nDigite a opcao desejada: ");
        opcao = input.nextInt();
        
        return opcao;
    }
}
