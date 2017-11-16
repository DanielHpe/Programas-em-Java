
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author daniel.pereira
 */

//Testes de Hashes
public class Hash {
    
    public HashMap hash1;
    public HashMap hash2;
    public HashMap hash3;
    
    public int[] vetor1 = new int[10];
    public int[] vetor2;
    public int[] vetor3;
    public int[] tabelaHash1 = new int[11];

    /**
     *
     */
    
    public int h;
 
    
    //Construtor recebe vetores
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
    }
    
    public void insercaoHash(){
        
        int prox = 0; //Ponteiro
        int auxiliar = 0;
        int j = 0;
          
        for(int i = 0; i < tabelaHash1.length; i++){
            tabelaHash1[i] = -1;
        }

        for(int i = 0; i < vetor1.length; i++){
            
            h = vetor1[i] % tabelaHash1.length; 
            auxiliar = h;
            if(tabelaHash1[auxiliar] == -1){
                tabelaHash1[auxiliar] = vetor1[i];
            } else {
                for(j = auxiliar; j < tabelaHash1.length; j++){
                    if(tabelaHash1[j] == -1){
                        tabelaHash1[j] = vetor1[i];
                        break;
                    }
                    if(j >= tabelaHash1.length - 1){
                        j = 0;
                        auxiliar = j;
                    }
                }
                       
            }
        }
        
        System.out.print("Hash: ");
        for(int i = 0; i < tabelaHash1.length; i++){
            System.out.print(tabelaHash1[i] + " ");
        }
        
        System.out.println("\n");
        
    }
    
}
    
        
        
       
           
    
    

