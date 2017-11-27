/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danih
 */

import java.util.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    
    static public String[] frases = {
            "O", "aspecto", "mais", "triste", "da",
        "vida", "neste", "momento", "é", "que", "a",
        "ciência", "ganha", "conhecimentos", "mais", "depressa",
        "do", "que", "a", "sociedade", "ganha", "juizo"
    };
    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
        
        /* Creating object of AATree */
        Trie t = new Trie(); 
        
        System.out.println("Trie Test\n");          
        char ch;

        //Criando árvore
        //Imprimindo árvore
        for(int i = 0; i < frases.length; i++){   
            t.insert(frases[i]);  
            System.out.print(frases[i] + " ");
        }
        
        System.out.println("\n");

        do    
        {
            System.out.println("\nTrie Operations\n");
            System.out.println("1. delete");
            System.out.println("2. search");
            System.out.print("Enter a operation: ");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter string element to delete");
                try
                {
                    t.remove( scan.next() ); 
                }                    
                catch (Exception e)
                {
                    System.out.println(e.getMessage()+" not found ");
                }
                break;                          
            case 2 : 
                System.out.println("Enter string element to search");
                System.out.println("Search result : "+ t.search( scan.next() ));
                break;                                            
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
    
}
