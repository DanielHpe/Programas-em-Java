
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danih
 */
public class Main {

    
    static  int opcao;
    static Scanner input;
    static int opt;
    static int[] vetorDesordenado = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
    
    public static void main(String[] args) {
        
        
        System.out.print("Vetor Desordenado: ");
        for(int i = 0; i < vetorDesordenado.length; i++){
            System.out.print(vetorDesordenado[i] + " ");
        }
        System.out.println("\n");
       
        do{
            opt = Main.exibirMenu();
            switch(opcao){
                case 0:
                    break;
                case 1:
                    selectSelectionSort();
                    break;
                case 2:
                    selectInsertionSort();
                    break;
                case 3:
                    selectShellSort();
                    break;
                case 4:
                    selectQuickSort();
                    break;
                default:
                    System.out.println("Opcao Inválida ! \n");             
            }
        } while (opcao != 0);
        
    }
    
    static public int exibirMenu(){
                      
        input = new Scanner(System.in);
  
        System.out.println("Algoritmos de Ordenação");
        System.out.println("1 - SeletionSort");
        System.out.println("2 - InsertionSort");
        System.out.println("3 - ShellSort");
        System.out.println("4 - QuickSort");
        System.out.print("Digite a opcao de ordenação desejada: ");        
        opcao = input.nextInt();
        System.out.println("\n");
    
        return opcao;
    }
    
    static public int[] doSelectionSort(int[] arr){
         
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) 
                    index = j;
      
            int smallerNumber = arr[index];  
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }
    
    static public int[] doInsertionSort(int[] vetor){
        
        int j;
        int key;
        int i;
   
        for (j = 1; j < vetor.length; j++)
        {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--)
            {
                vetor[i + 1] = vetor[i];
            }
            vetor[i + 1] = key;
        }
        
        return vetor;
    }
    
    static public int[] doShellSort(int[] vet){
        
        int i , j , temp, size = vet.length;

        int incremento = 1;
        while(incremento < size) {
            incremento = 3 * incremento + 1;
        }

        while (incremento > 1) {
            incremento /= 3;

            for(i = incremento; i < size; i++) {
                temp = vet[i];
                j = i - incremento;
                while (j >= 0 && temp < vet[j]) {
                    vet[j + incremento] = vet[j];
                    j -= incremento;
                }
                vet [j + incremento] = temp;
            }
        }	  
        
        return vet;
    }	
    
    public static void doQuickSort(int v[], int esquerda, int direita) {
        
        int esq = esquerda;
        int dir = direita;
        int pivo = v[(esq + dir) / 2];
        int troca;
        while (esq <= dir) {
            while (v[esq] < pivo) {
                    esq = esq + 1;
            }
            while (v[dir] > pivo) {
                    dir = dir - 1;
            }
            if (esq <= dir) {
                    troca = v[esq];
                    v[esq] = v[dir];
                    v[dir] = troca;
                    esq = esq + 1;
                    dir = dir - 1;
            }
        }
        if (dir > esquerda)
                doQuickSort(v, esquerda, dir);
        if (esq < direita)
                doQuickSort(v, esq, direita);
    }
     
    static public void selectSelectionSort(){
         
        int[] arr1 = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
        int[] arr2 = doSelectionSort(arr1);
        int[] arr3 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("\n");
        
    }
    
    static public void selectInsertionSort(){
        
        int[] arr1 = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
        int[] arr2 = doInsertionSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("\n");
    }
    
    static public void selectShellSort(){
        
        int[] arr1 = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
        int[] arr2 = doShellSort(arr1);
        for(int i:arr2){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println("\n");
    }
    
    static public void selectQuickSort(){
        
        int[] arr1 = {3, 4, 9, 2, 5, 8, 2, 1, 7, 4, 6, 2, 9, 8, 5, 1};
        doQuickSort(arr1, 0, arr1.length - 1);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
	}
        System.out.println("\n");
    }
       
}
    

