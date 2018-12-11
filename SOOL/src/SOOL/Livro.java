/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

/**
 *
 * @author danih
 */
public class Livro {
    
    private String titulo;
    private int quantidade;

    public Livro(String titulo, int quantidade){
            this.titulo = titulo;
            this.quantidade = quantidade;
    }

    public String getTitulo(){
            return titulo;
    }

    public void setTitulo(String titulo){
            this.titulo = titulo;
    }

    public int getQuantidade(){
            return quantidade;
    }

    public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
    }
    
}
