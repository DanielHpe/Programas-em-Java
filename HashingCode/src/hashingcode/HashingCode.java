/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashingcode;

/**
 *
 * @author danih
 */

import java.util.*;

public class HashingCode {

    /**
     * @param args the command line arguments
     */
    
    final static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static public String array = "XXXXXXXXXXX"; 
    static public String nome = "DANIEL HENRIQUE PEREIRA";
    static public String letrasRestantes = "PRSTUVWXYZ";
    static public String stringGerada;
    static public String novo;
    static public StringBuilder build; 
    static public String[] hash = new String[13];
    static public Scanner input;
    static public String maisUm;
    static public String caracterBuscado;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int i = 0;
        input = new Scanner(System.in);
        
        novo = array.replaceAll(array, nome);
        String a = novo.replaceAll("\\s", "");
        build = new StringBuilder(a);
        
        while( i < build.length())
        {
            int j=1+i;
            while(j < build.length())
            {   
                if(build.charAt(i)==build.charAt(j))
                {
                    build.deleteCharAt(j);
                }
                else
                {
                    j=j+1;
                }
            }
            i=i+1;
        }
        
        i = 0;
        int j;
        int contador;
        while( i < letrasRestantes.length())
        {
            contador = 0;
            j = 0;
            while(j < build.length())
            {   
                if(letrasRestantes.charAt(i) != build.charAt(j))
                {
                    contador++;
                }
                j=j+1;
            }
            if(contador >= build.length()){
                build.append(letrasRestantes.charAt(i));
            } 
            i=i+1;
        }
        
        stringGerada = build.subSequence(0, 12).toString();
        System.out.println(stringGerada);
        insercaoHash(stringGerada);
        
        do{
            
            System.out.print("\nDigite o caracter a ser buscado: ");
            caracterBuscado = input.next();
            while(caracterBuscado.length() > 1){
                System.out.print("Caracter muito grande ! Informe o caracter novamente: ");
                caracterBuscado = input.next();
                pesquisaHash(caracterBuscado);
            }

            if(pesquisaHash(caracterBuscado) == true){
                System.out.println("Caracter encontrado na Hash");
            } else {
                System.out.println("Caracter não encontrado");
            }
            
            System.out.print("Deseja buscar outro caracter ? ");
            maisUm = input.next();
            while(!maisUm.equals("yes") && !maisUm.equals("no")){
                System.out.print("Comando incorreto! Deseja buscar outro caracter? (yes/no): ");
                maisUm = input.next();
            }
            
        } while (!maisUm.equals("no"));
        
        System.out.print("\n");
        
    }
    
    static public void insercaoHash(String s){
        
        int auxiliar; 
        int j;
        int h;
        int[] vetor = new int[s.length()];
        
        //A chave é a posição do caracter no Alfabeto
        System.out.println("\n");
        for(int i = 0; i < s.length(); i++){
            vetor[i] = alphabet.indexOf(s.charAt(i) + 1);
            System.out.print(vetor[i] + " ");
        } 
        
        for(int i = 0; i < s.length(); i++){
            h = vetor[i] % hash.length; 
            auxiliar = h;
            if(hash[auxiliar] == null){ 
                hash[auxiliar] = Character.toString(s.charAt(i)); 
            } else {
                for(j = auxiliar; j < hash.length; j++){ 
                    if(hash[j] == null){ 
                        hash[j] = Character.toString(s.charAt(i)); 
                        break; 
                    }
                    if(j >= hash.length - 1){
                        j = 0;
                        auxiliar = j;
                    }
                }

            }
        }
        
        System.out.println("\n");
        for(int i = 0; i < hash.length; i++){
            System.out.print(hash[i] + " ");
        }
   
    }
    
    static public boolean pesquisaHash(String k){
        
        for(int j = 0; j < hash.length; j++){ //Percorrer a Hash em busca do valor desejado
            if(hash[j].equals(k)){ //Se a Hash na posição j for igual ao valor randomico buscado
                return true;
            }
        }
        return false;
    }
    
}
