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
public class ContaCorrente extends Conta {
    
    private double limite;

    public ContaCorrente(long numero, double saldo, double l) {
        super(numero, saldo);
        if (l > 0) {
            this.limite = l;
        }
    }

    public void alterarLimite(double l){
        limite = l;
    }
    
    public double consultarlimite(){
        return limite;
    }
    
    @Override
    public boolean sacar(double v){
        if (v > 0 && ((saldo + limite - v) >= 0)) {
            saldo = saldo - v;
            return true;
        } else {
            return false;
        }
        
    }
    
    public double consultarSaldoTotal(){
        return (saldo + limite);
    }
    
}
