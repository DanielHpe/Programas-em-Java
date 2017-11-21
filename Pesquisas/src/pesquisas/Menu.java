/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisas;

import java.util.Scanner;

/**
 *
 * @author daniel.pereira
 */

//Classe Menu
//Contém o Menu de Buscas (Árvore de Pesquisa binária e Hash)
public class Menu {
    
    int opcao;
    Scanner input = new Scanner(System.in);
    
    public Menu(){
        opcao = 0;
    }
        
    public int exibirMenu(){
       
        System.out.println("Menu de Pesquisa");
        System.out.println("1 - Pesquisa de Hash");
        System.out.println("2 - Árvore Binária");
        System.out.print("Digite a opcao de pesquisa desejada: ");        
        opcao = input.nextInt();
        System.out.println("\n");
        
        return opcao;
        
    }
    
}
