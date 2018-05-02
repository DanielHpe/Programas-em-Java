
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
    
    static int opcao, meses;
    static Menu menu = new Menu();
    static float salario, novoSalario, valorFerias, decimoTerceiro;
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        do{
            
           opcao = menu.mostrarMenu();
           
           switch(opcao){
                case 1:
                    System.out.println("Digite o salario: ");
                    salario = input.nextFloat();
                    if(salario < 999){
                       novoSalario = (float) (salario + (salario * 0.15));           
                    } else if(salario > 1000 && salario <= 2000){
                       novoSalario = (float) (salario + (salario * 0.1));
                    } else if(salario > 2000){
                       novoSalario = (float) (salario + (salario * 0.05));
                    }
                    System.out.println("Novo salário com aumento é: " + novoSalario);
                    break;
                case 2:
                    System.out.println("Digite o salario: ");
                    salario = input.nextFloat();
                    valorFerias = salario + (salario / 3);
                    System.out.println("Valor ganho de ferias é: " + valorFerias);
                    break;
                case 3:
                    System.out.println("Digite o salario: ");
                    salario = input.nextFloat();
                    System.out.println("Digite o numero de meses trabalhados: ");
                    meses = input.nextInt();
                    while(meses > 12){
                        System.out.println("Digite o numero de meses trabalhados: ");
                        meses = input.nextInt();
                    }
                    decimoTerceiro = (salario * meses) / 12;
                    System.out.println("Valor ganho de décimo terceiro é: " + decimoTerceiro);
                    break;
                case 4:
                    break;
                default:
                   System.out.println("Opcao invalida");
                   break;
           }    
        } while(opcao != 4);
    }
    
}
