package pesquisas;



import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author daniel.pereira
 */

//Classe Hash
//Cada vetor, possui 1 tabela Hash própria. Cujo tamanho é o próximo número primo acima do vetor
//A inserção dos valores nos vetores é feita através de uma função de Hash e um sistema de detecção de colisões
//Se detectada uma colisão (inserção de um valor num espaço já ocupado), insere elemento na próxima posição vazia
//Após a inserção dos valores nas Hashes, é possível se fazer a pesquisa de valores na mesma
//Pesquisa de 100 valores randômicos de (0 à 100.000) nas Hashes
//Retorno do número de comparações
//Retorno do número de valores encontrados na busca
//Retorno dos valores encontrados na busca
public class Hash {
    
    public int[] vetor1 = new int[10];
    public int[] vetor2;
    public int[] vetor3;
    
    public int[] tabelaHash1;
    public int[] tabelaHash2;
    public int[] tabelaHash3;
    
    public int h;
    public int randomTamanho;
    
    //Tamanhos das hashes
    int num1;
    int num2;
    int num3;
    
    public Random random = new Random();
   
    //Construtor recebe vetores e o randomTamanho (valor limite de possibilidades de aleatórios)
    public Hash(int[] vetor1, int[] vetor2, int[] vetor3, int randomTamanho){
        this.vetor1 = vetor1;
        this.vetor2 = vetor2;
        this.vetor3 = vetor3;
        this.randomTamanho = randomTamanho;
    }
    
    //Calcula Tamanho da HASH
    //Tamanho da Hash deve ser o próximo número primo acima do tamanho do vetor
    public void calculaTamanhoHash(){
        
        boolean verificador = false;
        
        num1 = vetor1.length - 1;
        num2 = vetor2.length - 1;
        num3 = vetor3.length - 1;
        
        while(verificador == false){
            num1++;
            for(int i=2;i<num1;i++) {
                if(num1%i == 0){
                    verificador = false;
                    break;
                } else {
                    verificador = true;
                }
            }    
        }
        
        verificador = false;
                
        while(verificador == false){
            num2++;
            for(int i=2;i<num2;i++) {
                if(num2%i == 0){
                    verificador = false;
                    break;
                } else {
                    verificador = true;
                }
            }    
        }
        
        verificador = false;
        
        while(verificador == false){
            num3++;
            for(int i=2;i<num3;i++) {
                if(num3%i == 0){
                    verificador = false;
                    break;
                } else {
                    verificador = true;
                }
            }    
        }
        
//        System.out.print("Proximo primo de vetor 1: " + num1);
//        System.out.print("\nProximo primo de vetor 2: " + num2);
//        System.out.print("\nProximo primo de vetor 3: " + num3);
//        System.out.println("\n\n");
    
    }
    
    //Método de inserção dos dados do Vetor 1 na HASH
    //Utilizando a Função de Hash (ou de Transformação), é feita a inserção
    //Detecção de colisões também implementada, caso a posição esteja ocupada, insere-se elemento no próximo campo vazio
    public void insercaoHash(){
        
             
        int auxiliar; 
        int j;
        
        this.calculaTamanhoHash();
        
        //Instanciando Hashes com tamanhos compatíveis
        //Tamanhos das Hashes são os valores primos calculados da função calculaTamanhoHash
        tabelaHash1 = new int[num1];
        tabelaHash2 = new int[num2];
        tabelaHash3 = new int[num3];
          
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
    
    //Pesquisa de 100 valores aleatórios (de 0 à 100.000) nas Hashes
    public void pesquisaHash(){
        
        int randomValor;
        int valorBuscado;
        int contHash1 = 0;
        int contHash2 = 0;
        int contHash3 = 0;
        int numComparacoes1 = 0;
        int numComparacoes2 = 0;
        int numComparacoes3 = 0;
        
        //ArrayLists que recebem os valores encontrados na Busca
        ArrayList<Integer> valoresEncontradosHash1 = new ArrayList<>();
        ArrayList<Integer> valoresEncontradosHash2 = new ArrayList<>();      
        ArrayList<Integer> valoresEncontradosHash3 = new ArrayList<>();
        
        //ArrayLists para eliminação de pesquisa de um mesmo valor
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> nums3 = new ArrayList<>();
        
        //Arraylist recebe randomTamanho valores em suas randomTamanho posições
        for(int i = 0; i < randomTamanho; i++){
            nums1.add(i);
        }
        
        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime1 = System.nanoTime();
        
        //Pesquisa de 100 valores aleatórios
        for(int i = 0; i < 100; i++){
            //Eliminar pesquisa de mesmo valor
            //Gerar sempre um valor de pesquisa diferente
            randomValor = random.nextInt(nums1.size()); //
            valorBuscado = nums1.get(randomValor); //valor a ser buscado recebe o valor do array no indice (randomValor)
            nums1.remove(randomValor); //Remover o indice sorteado para eliminar as repetições
            for(int j = 0; j < tabelaHash1.length; j++){ //Percorrer a Hash em busca do valor desejado
                if(tabelaHash1[j] == valorBuscado){ //Se a Hash na posição j for igual ao valor randomico buscado
                    contHash1++; //contador de valores encontrados recebe +1;
                    numComparacoes1++; //Valor de comparacões recebe +1
                    valoresEncontradosHash1.add(tabelaHash1[j]); //ArrayList de valores encontrados recebe o valor
                    break;
                }
                else{
                    numComparacoes1++; //Valor de comparacoes recebe +1
                }
            }    
        }
        
        long timeNano = System.nanoTime() - startTime1;
        
        for(int i = 0; i < randomTamanho; i++){
            nums2.add(i);
        }
        
        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime2 = System.nanoTime();
        
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
                    break;
                } else {
                    numComparacoes2++;
                }
            }    
        }
        
        long timeNano2 = System.nanoTime() - startTime2;

        for(int i = 0; i < randomTamanho; i++){
            nums3.add(i);
        }
        
        //Utilizando o método nanoTime da classe System para obter o tempo de execução da busca
        long startTime3 = System.nanoTime();
                
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
                    break;
                } else {
                    numComparacoes3++;
                }
            }    
        }
        
        long timeNano3 = System.nanoTime() - startTime3;

        //Impressão das informações:
        //Numeros de valores encontrados em cada Hash
        //Array de valores encontrados em cada Hash
        //Numero de comparacoes do valor buscado com a posição na Hash de cada Hash
        System.out.println("Foram encontrados " + contHash1 + " valores na pesquisa randômica da Hash 1");
        System.out.print("Valores encontrados na Hash 1: ");
        for(int i = 0; i < valoresEncontradosHash1.size(); i++){
            System.out.print(valoresEncontradosHash1.get(i) + " ");
        }
        System.out.println("\nNúmero de comparações na Hash 1 é: " + numComparacoes1);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano / 1000000);
        
        System.out.println("\nForam encontrados " + contHash2 + " valores na pesquisa randômica da Hash 2"); 
        System.out.print("Valores encontrados na Hash 2: ");
        for(int i = 0; i < valoresEncontradosHash2.size(); i++){
            System.out.print(valoresEncontradosHash2.get(i) + " ");
        }
        System.out.println("\nNúmero de comparações na Hash 2 é: " + numComparacoes2);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano2 / 1000000);
        
        System.out.println("\nForam encontrados " + contHash3 + " valores na pesquisa randômica da Hash 3"); 
        System.out.print("Valores encontrados na Hash 3: ");
        for(int i = 0; i < valoresEncontradosHash3.size(); i++){
            System.out.print(valoresEncontradosHash3.get(i) + " ");
        }
        System.out.println("\nNúmero de comparações na Hash 3 é: " + numComparacoes3);
        System.out.printf("Tempo de execução da busca é: %3.3f milissegundos%n", (double) timeNano3 / 1000000);
        System.out.println("\n");
    }
}