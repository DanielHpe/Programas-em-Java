package projeto.pkg1;

import projeto.pkg1.ContaTest;

public class Conta extends ContaTest {
    double balance;
   
    ContaTest conta;
    
    public Conta(double initialBalance){
        //valida que initialBalance é maior que 0.0
        //se não, o saldo é inicializado como o valor padrão 0.0
        if(initialBalance > 0.0)
            balance = initialBalance;
        
    } //Fim do método construtor
    
    //Método que adiciona uma quantia a conta
    public void credit(double quantia){
        balance = balance + quantia; //Adiciona uma quantia ao saldo
    }
    
    //Método que saca um valor da conta
    public void saque(double quantia){
        if(balance > quantia)
            balance = balance - quantia;
    }       
    
    //Método de transferência de valor entre as contas
    public void transferencia(double quantia){
        System.out.println("\nOlá Mundo");
    //    balance = balance - quantia;
    }
    
    //Método que retorna o saldo da conta
    public double getBalance(){
        return balance;
    }
    
    
} //Fim da classe Conta
    

