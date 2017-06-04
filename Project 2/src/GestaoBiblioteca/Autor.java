/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoBiblioteca;

/**
 *
 * @author 11427998
 */
public class Autor {
    private String nome;
    
    public Autor(){
        this.nome = null;
    } 
    
    public void setNome(String n){
        this.nome = n;
    }

     public String getNome(){
        return this.nome;
    }
    
}
