package projeto.pkg1;

import java.util.Scanner;
public class AcessoContas {
    int conta;
    int cont;
    Scanner input = new Scanner(System.in);
            
    public int acesso(){
        //Acessando as contas para transferência
        System.out.println("1 - Conta 1");
        System.out.println("2 - Conta 2");
        System.out.println("\nDigite qual conta quer acessar: ");
        conta = input.nextInt();
        
        //Retornando o valor conforme a conta escolhida 
        if(conta == 1)
            return 1;
        if(conta == 2);
            return 2;
    }
    
}
