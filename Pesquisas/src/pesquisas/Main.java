
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author daniel.pereira
 */

public class Main {
    
    static int[] vetor1;
    static int[] vetor2;
    static int[] vetor3;
    static ArrayList<Integer> numeros;
    static ArrayList<Integer> numeros2;
    static ArrayList<Integer> numeros3;


    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instanciando os vetores
        vetor1 = new int[1000];
        vetor2 = new int[5000];
        vetor3 = new int[10000];
        
        //Valores randômicos de 0 à 100.000
        //Alterar para o número de Random desejado
        int randomTamanho = 100000;
        
        //Utilizando ArrayLists para valores aleatórios e eliminação de repetições
        numeros = new ArrayList<>();
        numeros2 = new ArrayList<>();
        numeros3 = new ArrayList<>();
        
        //Classe Random
        Random random = new Random();
        
        for(int i = 0; i < randomTamanho; i++){
            numeros.add(i); //Adicionando 100 valores no array
        }
        
        boolean conflito = true;
        
        //Preenchendo os vetores
        System.out.print("Vetor 1: ");
        for(int i = 0; i < vetor1.length; i++){
            int rand = random.nextInt(numeros.size());
            vetor1[i] = numeros.get(rand); // Pegar o índice sorteado
            numeros.remove(rand); //Remover índice sorteado
            System.out.print(vetor1[i] + " ");
        }
//       
        System.out.println("\n");
        
        for(int i = 0; i < randomTamanho; i++){
            numeros2.add(i);
        }
      
        System.out.print("Vetor 2: ");
        for(int i = 0; i < vetor2.length; i++){
            int rand = random.nextInt(numeros2.size());
            vetor2[i] = numeros2.get(rand); // Pegar o índice sorteado
            numeros2.remove(rand); //Remover índice sorteado
            System.out.print(vetor2[i] + " ");
        }

              
        System.out.println("\n");
        
        for(int i = 0; i < randomTamanho; i++){
            numeros3.add(i);
        }
        
        System.out.print("Vetor 3: ");
        for(int i = 0; i < vetor3.length; i++){
            int rand = random.nextInt(numeros3.size());
            vetor3[i] = numeros3.get(rand); // Pegar o índice sorteado
            numeros3.remove(rand); //Remover índice sorteado
            System.out.print(vetor3[i] + " ");
        }
        
        System.out.println("\n");
        
        //Classe Hash
        Hash hash = new Hash(vetor1, vetor2, vetor3, randomTamanho);
        
        //Chamada do método para inserção na Hash
        hash.insercaoHash();
        
        //Chamada do método de pesquisa de 100 valores randômicos na Hash
        hash.pesquisaHash();
        
    }
    
}
