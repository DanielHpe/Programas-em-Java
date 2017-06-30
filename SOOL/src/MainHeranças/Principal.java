/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Heranças.ContaCorrente;

/**
 *
 * @author 11427998
 */
public class Principal {
    public static void main(String[] args){
        ContaCorrente CC = new ContaCorrente(1234, 0, 1000);
        CC.Depositar(500);
        CC.sacar(400);
        
        System.out.println("Limite: " + CC.consultarlimite());
        System.out.println("Saldo: " + CC.getSaldo());
        System.out.println("Saldo: " + CC.consultarSaldoTotal());
        

        
    }
    
}
