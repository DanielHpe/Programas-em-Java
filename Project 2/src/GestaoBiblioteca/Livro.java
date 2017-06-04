/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoBiblioteca;
 
public class Livro {
    private Autor autor;
    private String titulo;
    private int isbn;

    public Livro(){
        this.autor = new Autor();
        this.titulo = null;
        this.isbn = 0;
    }
    
    public void setAutor(Autor A){
        this.autor = A;
    }
    public void settitulo(String T){
        this.titulo = T;
    }
    public void setISBN(int isbn){
        this.isbn = isbn;
    }
       
    public String gettitulo(){
         return this.titulo;
    }
    public int getISBN(){
        return this.isbn;
    }

    public Autor getAutor() {
        return this.autor;
 
    }
}
