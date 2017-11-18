

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
    
    public int[] vetor1 = new int[10];
    public int[] vetor2;
    public int[] vetor3;
    
    public int[] tabelaHash1 = new int[11];
    public int[] tabelaHash2 = new int[23];
    public int[] tabelaHash3 = new int[31];
    
    public int h;
   
    //Construtor recebe vetores
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
    }
    
    //Método de inserção dos dados do Vetor 1 na HASH
    //Utilizando a Função de Hash (ou de Transformação), é feita a inserção
    //Detecção de colisões também implementada, caso a posição esteja ocupada, insere-se elemento no próximo campo vazio
    public void insercaoHash(){
        
        int auxiliar = 0; 
        int j = 0;
          
        for(int i = 0; i < tabelaHash1.length; i++){
            tabelaHash1[i] = -1; //Todos os valores da Hash recebem -1 pra indicar campo vazio 
        }

        for(int i = 0; i < vetor1.length; i++){ 
            
            h = vetor1[i] % tabelaHash1.length; //Função de transformação
            auxiliar = h; //Auxiliar funciona como uma espécie de ponteiro
            if(tabelaHash1[auxiliar] == -1){ //Se Hash na posição auxiliar for -1 (Vazia)
                tabelaHash1[auxiliar] = vetor1[i]; //Hash na posição auxiliar recebe a chave
            } else { //Se posição não for -1 (Não vazia)
                for(j = auxiliar; j < tabelaHash1.length; j++){ //Percorre a hash até o final em busca do próximo campo vazio
                    if(tabelaHash1[j] == -1){ //Se encontrar a posição vazia
                        tabelaHash1[j] = vetor1[i]; //Hash nessa posição (j) recebe a chave
                        break; //Imediatamente após isso, break na condição 
                    }
                    if(j >= tabelaHash1.length - 1){ //Se j for maior ou igual ao tamanho da Hash -1
                        j = 0; //Reinicia-se j para buscar campos vazios anteriores
                        auxiliar = j; //Auxiliar recebe o valor reiniciado de j
                    }
                }
                       
            }
        }
        
        for(int i = 0; i < tabelaHash2.length; i++){
            tabelaHash2[i] = -1; //Todos os valores da Hash recebem -1 pra indicar campo vazio 
        }

        for(int i = 0; i < vetor2.length; i++){ 
            
            h = vetor2[i] % tabelaHash2.length; //Função de transformação
            auxiliar = h; //Auxiliar funciona como uma espécie de ponteiro
            if(tabelaHash2[auxiliar] == -1){ //Se Hash na posição auxiliar for -1 (Vazia)
                tabelaHash2[auxiliar] = vetor2[i]; //Hash na posição auxiliar recebe a chave
            } else { //Se posição não for -1 (Não vazia)
                for(j = auxiliar; j < tabelaHash2.length; j++){ //Percorre a hash até o final em busca do próximo campo vazio
                    if(tabelaHash2[j] == -1){ //Se encontrar a posição vazia
                        tabelaHash2[j] = vetor2[i]; //Hash nessa posição (j) recebe a chave
                        break; //Imediatamente após isso, break na condição 
                    }
                    if(j >= tabelaHash2.length - 1){ //Se j for maior ou igual ao tamanho da Hash -1
                        j = 0; //Reinicia-se j para buscar campos vazios anteriores
                        auxiliar = j; //Auxiliar recebe o valor reiniciado de j
                    }
                }
                       
            }
        }
        
        for(int i = 0; i < tabelaHash3.length; i++){
            tabelaHash3[i] = -1; //Todos os valores da Hash recebem -1 pra indicar campo vazio 
        }

        for(int i = 0; i < vetor3.length; i++){ 
            
            h = vetor3[i] % tabelaHash3.length; //Função de transformação
            auxiliar = h; //Auxiliar funciona como uma espécie de ponteiro
            if(tabelaHash3[auxiliar] == -1){ //Se Hash na posição auxiliar for -1 (Vazia)
                tabelaHash3[auxiliar] = vetor3[i]; //Hash na posição auxiliar recebe a chave
            } else { //Se posição não for -1 (Não vazia)
                for(j = auxiliar; j < tabelaHash3.length; j++){ //Percorre a hash até o final em busca do próximo campo vazio
                    if(tabelaHash3[j] == -1){ //Se encontrar a posição vazia
                        tabelaHash3[j] = vetor3[i]; //Hash nessa posição (j) recebe a chave
                        break; //Imediatamente após isso, break na condição 
                    }
                    if(j >= tabelaHash3.length - 1){ //Se j for maior ou igual ao tamanho da Hash -1
                        j = 0; //Reinicia-se j para buscar campos vazios anteriores
                        auxiliar = j; //Auxiliar recebe o valor reiniciado de j
                    }
                }
                       
            }
        }
        
        //Impressão da Hash criada
        System.out.print("Hash 1: ");
        for(int i = 0; i < tabelaHash1.length; i++){
            System.out.print(tabelaHash1[i] + " ");
        }
        
        //Impressão da segunda Hash criada
        System.out.println("\n");
        System.out.print("Hash 2: ");
        for(int i = 0; i < tabelaHash2.length; i++){
            System.out.print(tabelaHash2[i] + " ");
        }
        
        //Impressão da terceira Hash criada
        System.out.println("\n");
        System.out.print("Hash 3: ");
        for(int i = 0; i < tabelaHash3.length; i++){
            System.out.print(tabelaHash3[i] + " ");
        }
        
        System.out.println("\n");
        
    }
    
    //Pesquisa de valores na Hash
    public void pesquisaHash(){
        
        
        
    }
    
}
    
        
        
       
           
    
    

