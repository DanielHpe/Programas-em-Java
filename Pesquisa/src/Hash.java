
import java.util.HashMap;

/**
 *
 * @author daniel.pereira
 */

//Testes de Hashes
public class Hash {
    
    public int[] vetor1;
    public int[] vetor2;
    public int[] vetor3;
    
    public int[] hash1 = new int[11];
    public int[] hash2 = new int[23];
    public int[] hash3 = new int[31];
     
    int h = 0;
    
    //Construtor recebe vetores
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
    }
    
    public void insercaoHash1(){
        
        int auxiliar = 0;
        int prox = 0;
        
        for(int i = 0; i < hash1.length; i++){
            hash1[i] = -1;
        }
        
        for(int i = 0; i < vetor1.length; i++){
            
            h = vetor1[i] % hash1.length;
            auxiliar = h;  
            if(hash1[auxiliar] == -1){ //Se vazio, insere na posição
                hash1[auxiliar] = vetor1[i];  
            } else { //Senão, confere o próximo elemento
                prox = auxiliar; //prox recebe auxiliar (posicão de momento)
                for(int j = prox; j < hash1.length; j++){ //For que vai da posição atual até o fim da hash
                    if(hash1[j] == -1){ //Se 
                        hash1[j] = vetor1[i];
                        if(j == hash1.length)
                            j = 0;
                        break;
                    }
                }
            }
            
        }
        
        System.out.println("Hash 1: ");
        for (int i = 0; i < 11; i++) {
            System.out.print(hash1[i] + " ");
        }
        
        System.out.println("\n");
       
    }
    
    public void insercaoHash2(){
        
        int auxiliar = 0;
        int prox = 0;
        
        for(int i = 0; i < hash2.length; i++){
            hash2[i] = -1;
        }
        
        for(int i = 0; i < vetor2.length; i++){
            
            h = vetor2[i] % hash2.length;
            auxiliar = h;  
            if(hash2[auxiliar] == -1){ //Se vazio, insere na posição
                hash2[auxiliar] = vetor2[i];  
            } else { //Senão, confere o próximo elemento
                prox = auxiliar; //prox recebe auxiliar (posicão de momento)
                for(int j = prox; j < hash2.length; j++){ //For que vai da posição atual até o fim da hash
                    if(hash2[j] == -1){ //Se 
                        hash2[j] = vetor2[i];
                        if(j == hash2.length)
                            j = 0;
                        break;
                    }
                }
            }
            
        }
        
        System.out.println("Hash 2: ");
        for (int i = 0; i < 23; i++) {
            System.out.print(hash2[i] + " ");
        }
        
        System.out.println("\n");
       
    }
    
    public void insercaoHash3(){
        
        int auxiliar = 0;
        int prox = 0;
        
        for(int i = 0; i < hash3.length; i++){
            hash3[i] = -1;
        }
        
        for(int i = 0; i < vetor3.length; i++){
            
            h = vetor3[i] % hash3.length;
            auxiliar = h;  
            if(hash3[auxiliar] == -1){ //Se posição está vazia (valor = -1), insere na posição
                hash3[auxiliar] = vetor3[i];  
            } else { //Senão, confere o próximo elemento
                prox = auxiliar; //prox recebe auxiliar (posicão de momento)
                for(int j = prox; j < hash3.length; j++){ //For que vai da posição atual até o fim da hash
                    if(hash3[j] == -1){ //Se 
                        hash3[j] = vetor3[i];
                        if(j == hash3.length)
                            j = 0;
                        break;
                    }
                }
            }
            
        }
        
        System.out.println("Hash 3: ");
        for (int i = 0; i < 31; i++) {
            System.out.print(hash3[i] + " ");
        }
        
        System.out.println("\n");
       
    }
    
    
    
}
