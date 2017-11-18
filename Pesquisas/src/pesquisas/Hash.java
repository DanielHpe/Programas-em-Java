

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author daniel.pereira
 */

//Testes de Hashes
public class Hash {
    
    public int[] vetor1 = new int[10];
    public int[] vetor2;
    public int[] vetor3;
    
    public int[] tabelaHash1 = new int[1001];
    public int[] tabelaHash2 = new int[5003];
    public int[] tabelaHash3 = new int[10001];
    
    public int h;
    public int randomTamanho;
    
    public Random random = new Random();
   
    //Construtor recebe vetores
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3, int randomTamanho){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
        this.randomTamanho = randomTamanho;
    }
    
    public void calculaTamanhoHash(){
        
    }
    
    //Método de inserção dos dados do Vetor 1 na HASH
    //Utilizando a Função de Hash (ou de Transformação), é feita a inserção
    //Detecção de colisões também implementada, caso a posição esteja ocupada, insere-se elemento no próximo campo vazio
    public void insercaoHash(){
        
        int auxiliar; 
        int j;
          
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
        
        int randomValor = 0;
        int valorBuscado = 0;
        int contHash1 = 0;
        int contHash2 = 0;
        int contHash3 = 0;
        int numComparacoes1 = 0;
        int numComparacoes2 = 0;
        int numComparacoes3 = 0;
        
        ArrayList<Integer> valoresEncontradosHash1 = new ArrayList<>();
        ArrayList<Integer> valoresEncontradosHash2 = new ArrayList<>();      
        ArrayList<Integer> valoresEncontradosHash3 = new ArrayList<>();
        
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> nums3 = new ArrayList<>();
        
        for(int i = 0; i < randomTamanho; i++){
            nums1.add(i);
        }
        
        for(int i = 0; i < 100; i++){
            //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums1.size());
            valorBuscado = nums1.get(randomValor);
            nums1.remove(randomValor);
            for(int j = 0; j < tabelaHash1.length; j++){
                if(tabelaHash1[j] == valorBuscado){
                    contHash1++;
                    numComparacoes1++;
                    valoresEncontradosHash1.add(tabelaHash1[j]);
                }
                else{
                    numComparacoes1++;
                }
            }    
        }
        
        for(int i = 0; i < randomTamanho; i++){
            nums2.add(i);
        }
        
        //Pesquisa de 100 valores aleatórios de 0 à 200
        for(int i = 0; i < 100; i++){
            //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums2.size());
            valorBuscado = nums2.get(randomValor);
            nums2.remove(randomValor);
            for(int j = 0; j < tabelaHash2.length; j++){
                if(tabelaHash2[j] == valorBuscado){
                    contHash2++;
                    numComparacoes2++;
                    valoresEncontradosHash2.add(tabelaHash2[j]);
                } else {
                    numComparacoes2++;
                }
            }    
        }

        for(int i = 0; i < randomTamanho; i++){
            nums3.add(i);
        }
                
        for(int i = 0; i < 100; i++){
            //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums3.size());
            valorBuscado = nums3.get(randomValor);
            nums3.remove(randomValor);
            for(int j = 0; j < tabelaHash3.length; j++){
                if(tabelaHash3[j] == valorBuscado){
                    contHash3++;
                    numComparacoes3++;
                    valoresEncontradosHash3.add(tabelaHash3[j]);
                } else {
                    numComparacoes3++;
                }
            }    
        }

        System.out.println("Foram encontrados " + contHash1 + " valores na pesquisa randômica da Hash 1");
        System.out.print("Valores encontrados na Hash 1: ");
        for(int i = 0; i < valoresEncontradosHash1.size(); i++){
            System.out.print(valoresEncontradosHash1.get(i) + " ");
        }
        System.out.println("\nNumero de comparacoes na Hash 1 é: " + numComparacoes1);
        
        System.out.println("\nForam encontrados " + contHash2 + " valores na pesquisa randômica da Hash 2"); 
        System.out.print("Valores encontrados na Hash 2: ");
        for(int i = 0; i < valoresEncontradosHash2.size(); i++){
            System.out.print(valoresEncontradosHash2.get(i) + " ");
        }
        System.out.println("\nNumero de comparacoes na Hash 2 é: " + numComparacoes2);
        
        System.out.println("\nForam encontrados " + contHash3 + " valores na pesquisa randômica da Hash 3"); 
        System.out.print("Valores encontrados na Hash 3: ");
        for(int i = 0; i < valoresEncontradosHash3.size(); i++){
            System.out.print(valoresEncontradosHash3.get(i) + " ");
        }
        System.out.println("\nNumero de comparacoes na Hash 3 é: " + numComparacoes3);
        System.out.println("\n");
    }
    
}