/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.util.Scanner;

/**
 *
 * @author danih
 */
public class Hash {

    /**
     * @param args the command line arguments
     */
    
    static Integer[] hash;
    static Scanner input;
    static Integer valor;
    static int decide;
    static boolean encontrado;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        hash = new Integer[13];
        input = new Scanner(System.in);;
        
        for(int i = 0; i < 12; i++){
            System.out.print("Digite a matricula: ");
            valor = input.nextInt();
            insercaoHash(valor, hash);
        }
        
        System.out.println("\nHash:");
        for(int i = 0; i < hash.length; i++){
            System.out.print(hash[i] + " ");
        }
        
        System.out.println("\n\nBuscar valor na Hash: ");
        do{
            System.out.print("Digite a matricula a ser procurada: ");
            valor = input.nextInt();
            encontrado = pesquisaHash(valor, hash);
            if(encontrado == true){
                System.out.println("\nValor encontrado!");
            } else {
                System.out.println("\nValor não encontrado!");
            }
            
            System.out.print("\nDeseja buscar outra matrícula ? (1 - SIM/2 - NÃO): ");
            decide = input.nextInt();
            while(decide != 1 && decide != 2){
                System.out.print("Comando incorreto! Deseja buscar a matricula ? (1 - SIM/2 - NÃO): ");
                decide = input.nextInt();
            }
            
        } while (decide != 2);
        
        System.out.println("\n\n");
    }
    
    static public void insercaoHash(int k, Integer[] hash){
        
        int auxiliar; 
        int j;
        int h;
        
        h = k % hash.length; //Função de transformação
        auxiliar = h; //Auxiliar funciona como uma espécie de ponteiro
        if(hash[auxiliar] == null){ //Se Hash na posição auxiliar for -1 (Vazia)
            hash[auxiliar] = k; //Hash na posição auxiliar recebe a chave
        } else { //Se posição não for -1 (Não vazia)
            for(j = auxiliar; j < hash.length; j++){ //Percorre a hash até o final em busca do próximo campo vazio
                if(hash[j] == null){ //Se encontrar a posição vazia
                    hash[j] = k; //Hash nessa posição (j) recebe a chave
                    break; //Imediatamente após isso, break na condição 
                }
                if(j >= hash.length - 1){
                    j = 0;
                    auxiliar = j;
                }
            }

        }
    }
    
    static public boolean pesquisaHash(Integer k, Integer[] hash){
        
        for(int j = 0; j < hash.length; j++){ //Percorrer a Hash em busca do valor desejado
            if(hash[j] == k){ //Se a Hash na posição j for igual ao valor randomico buscado
                return true;
            }
        }
        
        return false;
    }
    
}
