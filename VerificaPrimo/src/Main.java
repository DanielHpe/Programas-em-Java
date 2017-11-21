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

    /**
     * @param args the command line arguments
     */
    
    static int[] vetor1 = new int[10];
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //preenchendo o vetor
        System.out.print("Vetor: ");
        for(int i = 0; i < vetor1.length; i++){
            vetor1[i] = i;
            System.out.print(vetor1[i] + " ");
        }
        
        int nPrimo = isPrime(vetor1);
        
        System.out.println("\n");
        System.out.println("Proximo primo: " + nPrimo);
        System.out.println("\n\n");
        
    }
    
    static public int isPrime(int[] v) {
        
        boolean verificador = false;
        int num = v.length - 1;
        
        while(verificador == false){
            num++;
            for(int i=2;i<num;i++) {
                if(num%i == 0){
                    verificador = false;
                    break;
                } else {
                    verificador = true;
                }
            }    
        }
        
        return num;
        
    }
}
