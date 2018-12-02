/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigohuffman;

/**
 * Classe entidade que simboliza um nó ou um conjunto de nós da árvore
 * @author Daniel H. Pereira
 * 
 */
public class Arvore implements Comparable<Arvore>{
    
    public Character simbolo;
    public Double probabilidade;
    public Arvore esquerdo;
    public Arvore direito;

    @Override
    public int compareTo(Arvore o) {
        return 1;
    }
   
   
}
