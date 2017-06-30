package projeto.pkg1;

import java.util.Scanner;

public class ContaTest {
    //Método main inicia a aplicação Java
    public static void main(String[] args){
        Conta c1 = new Conta(50.00); //Cria o objeto Conta
        Conta c2 = new Conta(-7.53); //Cria o objeto Conta
        Menu m = new Menu();
        AcessoContas access = new AcessoContas();
        Scanner input = new Scanner(System.in);
        
        
        //Exibe o saldo inicial de cada objeto
        System.out.printf("Conta1 balance: $%.2f\n", c1.getBalance());
        System.out.printf("Conta2 balance: $%.2f\n", c2.getBalance());
        
        //Cria Scanner para obter a entrada a partir da janela de comando
        double valorDeposito;
        double valorSaque;
        double valorTransf;
        int retorno;
        
        //Variável para operar o menu;
        int option;
        
        do{
            //Option recebe o valor retornado por menu
            option = m.menu();
            
            switch(option){
                case 1:
                    //Entra com o deposito na conta 1
                    System.out.print("\nEntre com o depósito para a conta 1: ");
                    valorDeposito = input.nextDouble(); //Usuario entra com o deposito
                    System.out.printf("Fazendo depósito de %.2f na conta 1: ", valorDeposito);
                    c1.credit(valorDeposito); //Adiciona o depósito efetuado ao saldo de 1
        
                    //Exibindo o novo saldo
                    System.out.printf("\nNovo saldo da conta 1: %.2f\n", c1.getBalance());
        
                    //Entra com o deposito na conta 2
                    System.out.print("\nEntre com o depósito para a conta 2: ");
                    valorDeposito = input.nextDouble(); //Usuario entra com o deposito
                    System.out.printf("Fazendo o depósito de %.2f na conta 2: ", valorDeposito);
                    c2.credit(valorDeposito); //Adiciona o depósito efetuado ao saldo de 2
        
                    //Exibindo o novo saldo
                    System.out.printf("\nNovo saldo da conta 2: %.2f\n", c2.getBalance());
                    System.out.println("");
                break;
                case 2:
                    //Saldo Atual
                    System.out.printf("Conta1 balance: $%.2f\n", c1.getBalance());
                    System.out.printf("Conta2 balance: $%.2f\n", c2.getBalance());
                    
                    //Sacando um valor da conta 1
                    System.out.println("Entre com um valor para o saque: ");
                    valorSaque = input.nextDouble(); //Usuário entra com um valor para sacar
                    System.out.printf("Fazendo o saque de %.2f da conta 1: ", valorSaque);
                    c1.saque(valorSaque); //Saca um valor da conta
        
                    //Exibindo o novo valor após o saque
                    System.out.printf("\nNovo salda da conta 1: %.2f\n", c1.getBalance());
        
                    //Sacando valor da conta 2
                    System.out.println("Entre com um valor para o saque: ");
                    valorSaque = input.nextDouble(); //Usuário entra com um valor para sacar
                    System.out.printf("Fazendo o saque de %.2f da conta 2: ", valorSaque);
                    c2.saque(valorSaque); //Saca um valor da conta
                    
                    //Exibindo o novo saldo
                    System.out.printf("\nNovo saldo da conta 2: %.2f\n", c2.getBalance());
                    System.out.println("");
                break;
                case 3:
                    //Transferindo de conta 1 para conta 2
                    //Saldo das contas
                    System.out.printf("\nConta1 balance: $%.2f\n", c1.getBalance());
                    System.out.printf("\nConta2 balance: $%.2f\n", c2.getBalance());
                    
                    do{
                        //Acessa o método "acesso" da classe AcessoContas
                        retorno = access.acesso();
                        if(retorno == 1)
                            System.out.println("Quanto deseja transferir a conta 2? ");
                            valorTransf = input.nextDouble();
                            System.out.printf("Transferindo %.2f para a conta 2", valorTransf);
                            c1.transferencia(valorTransf);
                        if(retorno == 2)
                            System.out.println("Quanto deseja transferir a conta 1? ");
                            valorTransf = input.nextDouble();
                            System.out.printf("Transferindo %.2f para a conta 1", valorTransf);
                            c2.transferencia(valorTransf);
                    }while(retorno != 1 || retorno != 2);
                }        
        }while(option != 0);
        
    }//Fim do main
}//Fim da classe
