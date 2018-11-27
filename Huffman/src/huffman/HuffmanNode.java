/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author Daniel Henrique
 */
public class HuffmanNode implements Comparable<HuffmanNode>{
    
    int frequency; // Frequency of the node (number of times shown in the text
    char data; // Character of the node
    HuffmanNode left, right; // Right and Left node

    public int compareTo(HuffmanNode node) {
        return frequency - node.frequency;
    }
}
