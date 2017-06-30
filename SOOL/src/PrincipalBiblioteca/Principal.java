/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import GestaoBiblioteca.Autor;
import GestaoBiblioteca.Livro;

/**
 *
 * @author 11427998
 */
public class Principal {
    public static void main(String[] args) {

    Livro lvr = new Livro();
    Autor aa = new Autor();
    aa.setNome("Ziviani");
    lvr.setAutor(aa);
    lvr.settitulo("Projeto de Algoritmos");
    lvr.setISBN(1234567);

    System.out.println("Autor:" + lvr.getAutor().getNome());
    System.out.println("Titulo: " + lvr.gettitulo());
    System.out.println("ISBN: " + lvr.getISBN());
}
    
}
