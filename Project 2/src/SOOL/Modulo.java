/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOOL;

/**
 *
 * @author 18077
 */
public class Modulo {
    private String codigo;
    private int quantCreditos;
    
    public Modulo(String c, int Q){
        this.codigo = c;
        this.quantCreditos = Q;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQuantCreditos() {
        return quantCreditos;
    }

    public void setQuantCreditos(int quantCreditos) {
        this.quantCreditos = quantCreditos;
    }
    
    
}
