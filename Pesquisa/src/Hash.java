
import java.util.HashMap;

/**
 *
 * @author daniel.pereira
 */

//Testes de Hashes
public class Hash {
    
    public HashMap hash1;
    public HashMap hash2;
    public HashMap hash3;
    
    public int[] vetor1;
    public int[] vetor2;
    public int[] vetor3;
    
    //Construtor recebe vetores
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
    }
    
    public void tamanhoHash(){
        
        //Instanciando Hashes
        hash1 = new HashMap();
        hash2 = new HashMap();
        hash3 = new HashMap();
        
        //Armazenando dados nos hashes
        for(int i = 0; i < vetor1.length; i++){
            hash1.put(i+1, vetor1[i]);
        }
        
        for(int i = 0; i < vetor2.length; i++){
            hash2.put(i+1, vetor2[i]);
        }
        
        for(int i = 0; i < vetor3.length; i++){
            hash3.put(i+1, vetor3[i]);
        }
        
        //Imprimindo Hashes
        System.out.println("Hash 1: " + hash1); 
        System.out.println("Hash 2: " + hash2); 
        System.out.println("Hash 3: " + hash3); 
    }
    
    
}
