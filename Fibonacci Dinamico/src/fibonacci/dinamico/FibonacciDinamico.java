/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci.dinamico;

import java.util.Scanner;

/**
 *
 * @author Daniel Henrique Pereira
 */

public class FibonacciDinamico {
    
    static public int[] vetor;
    static int contadorRecursivo = 1;
    static int contadorDinamico = 1;
     
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
    //    ArrayList array = new ArrayList<>();
        
        System.out.println("Digite o valor de Fibonacci desejado: ");
        int valor = input.nextInt();
        
        vetor = new int[valor+1];
        
        System.out.println("\n");
               
        /* System.out.println("Fibonacci recursivo: ");
        
        for(int i = 0; i < valor; i++){
            System.out.print(fibonacci(i+1) + " ");
        } 
        
        System.out.println("\n");
        System.out.println("Numero de chamadas recursivas: " + contadorRecursivo);
        System.out.println("\n"); */
        
        /* System.out.println("Fibonacci dinâmico: ");
        
         for(int i = 0; i < valor; i++){
            System.out.print(fibonacciDinamico(i) + " ");
        } */
            
        //Definir todos os valores do vetor para -1 p/ auxiliar no sistema de memorização
        for(int i = 0; i < valor+1; i++){
            vetor[i] = -1;
        }
        
        System.out.println("Fibonacci dinamico: ");
        for(int i = 1; i <= valor; i++){
            System.out.print(fiboDinamico(i) + " ");
        } 
        
       // int result = fiboDinamico(valor);
       // System.out.println("Resultado: " + result);
        
        System.out.println("\n");
        System.out.println("Numero de chamadas dinamicas: " + contadorDinamico);
        System.out.println("\n\n");
    }
    
    // Função de fibonacci recursivo 
    // Tempo de execução muito maior ao do Fibonacci Dinâmico
    static public int fibonacci(int num){
        if(num == 1 || num == 2){
            contadorRecursivo++;
            return 1;
        }
        else{
            contadorRecursivo++;
            return fibonacci(num - 1) + fibonacci(num - 2);
        }
    }
   
    /* static public int fibonacciDinamico(int num){
        int[] fib = new int[num+2];
        
        fib[0] = 1;
        fib[1] = 1;
        
        for(int i = 2; i <= num; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        
        return fib[num];
    } */
    
    //Fibonacci utilizando programação dinâmica
    //Através da fórmula de memorização, pode-se calcular o fibonacci de grandes valores muito mais rápido do que o recursivo
    static public int fiboDinamico(int num){

        if(num <= 1){
            return num;
        }
        //Quando um valor do vetor ainda não foi calculado, o resultado é -1
        //Quando esse valor é calculado (chamado recursivamente), o resultado de -1 é alterado para o resultado correto
        //Se esse valor é chamado novamente, o resultado já não será mais -1, ou seja, o resultado foi memorizado
        //O resultado do vetor nessa posição é retornado
        if(vetor[num] != -1){
            return vetor[num];
        }
        vetor[num] = fiboDinamico(num-1) + fiboDinamico(num-2);
        contadorDinamico++;
        return vetor[num];
    }
}
