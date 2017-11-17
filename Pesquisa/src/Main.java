
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


    public static void main(String[] args) {
        // TODO code application logic here
        
        //Instanciando os vetores
        vetor1 = new int[10];
        vetor2 = new int[20];
        vetor3 = new int[30];
        
        
        
        //Utilizando um ArrayList para valores aleatórios e eliminação de repetições
        numeros = new ArrayList<Integer>();
        
        //Classe Random
        Random random = new Random();
        
        for(int i = 0; i < 100; i++){
            numeros.add(i); //Adicionando 100 valores no array
        }
        
        boolean conflito = true;
        
        //Preenchendo os vetores
        System.out.println("Vetor 1: ");
        for(int i = 0; i < 10; i++){
            int rand = random.nextInt(numeros.size());
            vetor1[i] = numeros.get(rand); // Pegar o índice sorteado
            numeros.remove(rand); //Remover índice sorteado
            System.out.print(vetor1[i] + " ");
        }
//       
//        System.out.println("\n\n");
//        
//        System.out.println("Vetor 2: ");
//        for(int i = 0; i < 20; i++){
//            vetor2[i] = random.nextInt(100);
//            System.out.print(vetor2[i] + " ");
//        }
//        
//        System.out.println("\n\n");
//        
//        System.out.println("Vetor 3: ");
//        for(int i = 0; i < 30; i++){
//            vetor3[i] = random.nextInt(100);
//            System.out.print(vetor3[i] + " ");
//        }
        
        System.out.println("\n");
        
        //Classe Hash
        Hash hash = new Hash(vetor1, vetor2, vetor3);
        
        hash.insercaoHash();
        
        
    }
    
}
