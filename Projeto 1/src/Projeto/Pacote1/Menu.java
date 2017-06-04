package projeto.pkg1;

import java.util.Scanner;

public class Menu {
    
    int opcao;  
    Scanner input = new Scanner(System.in);
    
    public int menu(){
        System.out.println("Menu do Banco");
        System.out.println("1 - Deposito");
        System.out.println("2 - Saque");
        System.out.println("3 - Transferencia");
        System.out.println("4 - Exibir dados bancários");
        System.out.printf("Digite a opção desejada: ");
        opcao = input.nextInt();
        
        return opcao;
    }
}
