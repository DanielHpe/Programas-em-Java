
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
    
    static int codigoProduto;
    static Scanner input;
    static float totalPago, precoProduto;
            
    public static void main(String[] args) {
        // TODO code application logic here
        
        input = new Scanner(System.in);
  
        System.out.println("Digite o preco do produto: ");
        precoProduto = input.nextInt();
        System.out.println("Digite o código do produto: ");
        codigoProduto = input.nextInt();

        
        switch(codigoProduto){
            case 1:     
                totalPago = (float) (precoProduto - (precoProduto * 0.1));
                System.out.println("Preco a ser pago é " + totalPago);
                break;
            case 2:
                totalPago = (float) (precoProduto - (precoProduto * 0.05));
                System.out.println("Preco a ser pago é " + totalPago);
                break;
            case 3:
                totalPago = precoProduto / 2;
                System.out.println("Valores das parcelas são de: " + totalPago);
                break;
            case 4:
                float valorJuros = (float) (precoProduto * 0.1);
                totalPago = (precoProduto / 2) + valorJuros;
                System.out.println("Valores pagos com juros: " + totalPago);
                break;
            default:
                System.out.println("Opcao inválida");
              
        } 
        
    }
    
}
