
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static String sexo; //m ou f
    static String corDosOlhos; //azuis, verdes ou castanhos
    static String corDosCabelos; //louros, castanhos ou pretos
    static int idade;
    
    static int numHabitantesF = 0;
    
    static Scanner input;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
           
        idade = 0;
        
        do{
            
            System.out.println("Digite o sexo (m ou f) ");
            sexo = input.next();
            while(!sexo.equals("m") && !sexo.equals("f")){
                System.out.println("Digite o sexo (m ou f) ");
                sexo = input.next();
            }
            
            System.out.println("Digite a cor dos olhos (a, v, c) ");
            corDosOlhos = input.next();
            while(!corDosOlhos.equals("a")  && !corDosOlhos.equals("v")  && !corDosOlhos.equals("c")){
                System.out.println("Digite a cor dos olhos (a, v, c) ");
                corDosOlhos = input.next();
            }
            
            System.out.println("Digite a cor dos cabelos (l, c, p) ");
            corDosCabelos = input.next();
            while(!corDosCabelos.equals("l")  && !corDosCabelos.equals("c")  && !corDosCabelos.equals("p")){
                System.out.println("Digite a cor dos cabelos (l, c, p) ");
                corDosCabelos = input.next();
            }
            
            System.out.println("Digite a idade: ");
            idade = input.nextInt();
            
            if(sexo.equals("f") && idade >= 18 && idade <= 35){
                numHabitantesF++;
            }
            
        } while(idade != -1);    
        
        System.out.println("O numero de habitantes do sexo feminino com idade entre 18 e 35 é: " + numHabitantesF);
        
    }
    
}
