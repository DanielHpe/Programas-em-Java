/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shiftand;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Daniel H. Pereira
 * 
 * Classe que simula um estado do automato
 * Caso argumento passado ao construtor seja 'true', o estado é final
 */
public class Estados {
    
    /**
     * Atributos
     */
    private boolean accept; // Estado aceito
    private Map<Character, Integer> transitions; // Transição de estados
    
    /**
     * Construtor da classe
     * @param accept 
     */
    public Estados (boolean accept){
        this.accept = accept;
        transitions = new HashMap<>();
    }

    /**
    * Retornar se o estado eh de aceitacao
    *
    * @return true se o estado eh de aceitacao,
    *   false em caso contrario
    */
    public boolean isAccept(){
        return accept;
    }

    /**
    * Adicionar uma transicao de estado
    *
     * @param symbol
     * @param state
    */
    public void addTransition(Character symbol, Integer state){
        transitions.put(symbol, state);
    }

    /**
    * Retornar o novo estado
    *
     * @param symbol
     * @return 
    */
    public Integer getTransition(Character symbol){
        return transitions.get(symbol);
    }
    
}
