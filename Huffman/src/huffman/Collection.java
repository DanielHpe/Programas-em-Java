/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daniel Henrique
 */
public class Collection {
    
    // Returns the frequency of the character passed in the character's list
    public static int returnFrequency(List<Character> list, Character character){
        
        return Collections.frequency(list, character);
        
    }
    
}
