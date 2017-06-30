/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heranças;

/**
 *
 * @author 11427998
 */
public class Conta {
    
    private long numero;
    protected double saldo;

    public Conta(long numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public void Depositar(double valor){
        saldo = saldo + valor;
    }
    
    public boolean sacar(double valor){
        if (valor > 0 && valor <= saldo){
            this.saldo = this.saldo - valor;
            return true;
        }
        else return false;
    }            
        
        
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
