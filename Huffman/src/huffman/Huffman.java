/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Daniel Henrique
 * 
 */
public class Huffman {

    private static Map<Character, String> charPrefixHashMap = new HashMap<>();
    public static HuffmanNode root; // Raiz da arvore
    public static List<Character> charArray; // Array de caracteres 
    public static Integer[] freqArray; // Array de frequencia
    public static HashMap<Character, Integer> hashFrequency; // Hash de frequencia dos caracteres do texto
    public static HashMap<Character, Integer> orderedHash; // Hash ordenada por valor
    private RandomAccessFile instance_file; // Referencia para o arquivo
    private static final int END_OF_FILE = -1; // Constante para fim do arquivo
    private static int lookahead = 0; // Armazena o último caractere lido do arquivo
    
    // Constructor
    public Huffman(String input_data){
        
        charArray = new ArrayList<>();
        hashFrequency = new HashMap<>();
        orderedHash = new HashMap<>();
        
        try {
            instance_file = new RandomAccessFile(input_data, "r");
	} catch(IOException e) {
            System.out.println("Erro de abertura do arquivo " + input_data + "\n" + e);
            System.exit(1);
	} catch(Exception e) {
            System.out.println("Erro do programa ou falha da tabela de simbolos\n" + e);
            System.exit(2);
	}
        
    }
    
    // Check if the string passed by paramater is ASCII 
    // Use of the external library Charset
    public static boolean isPureAscii(String s) {
        return Charset.forName("ISO-8859-1").newEncoder().canEncode(s);
    }
    
    // Closing the file
    public void closeFile() {

        try {
            instance_file.close();
        }catch (IOException errorFile) {
            System.out.println ("Erro ao fechar arquivo\n" + errorFile);
            System.exit(3);
	}
    }
    
    
    // Read the file which contains the text (by character)
    // Creates a list of characters from the readed text
    // If the character founded is ASCII, the list receives the char 
    public void readText(){
        
	char c;
        
        while(true){
                
            c = '\u0000'; // null char
            try {
                lookahead = instance_file.read(); 
		if(lookahead != END_OF_FILE) {
                    c = (char) lookahead;
                }
            } catch(IOException e) {
                System.out.println("Erro na leitura do arquivo");
                System.exit(3);
            }
            
            if (lookahead == END_OF_FILE){
                break;
            } else if (c == ' ' || c == '\t' || c == '\n' || c == '\r'){
                charArray.add(c);
            } else if (isPureAscii(Character.toString(c))){ // ASCII contains caracter
                charArray.add(c);
            }            
        }
      
        getFrequency();
  
    }
    
    // Get the frequency of the founded characters 
    /* Creates a ordered hash which contains the character founded (key) and the frequency 
       of that character in the text (Example: If founded 3 'c', the frequency of c is 3*/  
    // The Hash is ordered by frequency values
    public void getFrequency(){
        
        for(int i = 0; i < charArray.size(); i++){
            orderedHash.put(charArray.get(i), Collection.returnFrequency(charArray, charArray.get(i)));
        }
        
        orderedHash = (HashMap) Sort.sortByValue(orderedHash);
        freqArray = new Integer[orderedHash.size()];
        
        int i = 0;
        Iterator iterator = orderedHash.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mEntry = (Map.Entry) iterator.next();
            freqArray[i] = Integer.parseInt(mEntry.getValue().toString());
            i++;
        } 
       
    }
    
    // Transforming the Frequency Hash into the tree
    // The father node receive weight equals to the sum of it's children
    // The structure is Bottom-Up (From the bottom, to the root)
    public void treeStructure(){
        
        // Creating PriorityQueues with the trees
        // Each node contains frequency (weight) and char founded (data) 
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Character c : orderedHash.keySet()) {
            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.data = c;
            huffmanNode.frequency = orderedHash.get(c);
            huffmanNode.left = null;
            huffmanNode.right = null;
            priorityQueue.offer(huffmanNode);

        }
        assert priorityQueue.size() > 0;
        while (priorityQueue.size() > 1) {
            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode sum = new HuffmanNode();

            sum.frequency = x.frequency + y.frequency;
            sum.data = '-';

            sum.left = x;

            sum.right = y;
            root = sum;

            priorityQueue.offer(sum);
        }
    }
    
    // Encode through the node (tree) the source text
    // If it's the left node, the code receive 0, if the right, 1
    // The characters of the text are only in the leaf node (no children)
    public void setPrefixCodes(HuffmanNode node, StringBuilder prefix){
        
        if (node != null) {
            if (node.left == null && node.right == null) {
		charPrefixHashMap.put(node.data, prefix.toString());
            } else {
		prefix.append('0');
		setPrefixCodes(node.left, prefix);
		prefix.deleteCharAt(prefix.length() - 1);
                prefix.append('1');
                setPrefixCodes(node.right, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
	}
       
    }
    
    // Encoded text 
    public String encodedText(){
        
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < charArray.size(); i++) {
            char c = charArray.get(i);
            s.append(charPrefixHashMap.get(c));
        }

        return s.toString(); 
        
    }
    
    // Main Method
    public static void main(String[] args) {
        
        Huffman huffman = new Huffman("texto.txt");
        huffman.readText();
        huffman.treeStructure();
        huffman.setPrefixCodes(root, new StringBuilder());
        System.out.println("Text to be encoded: " + charArray);
        System.out.println("Frequency Hash: " + orderedHash);
        System.out.println("Prefix tree Hash: " + charPrefixHashMap +
                " (Most frequent with less bits and less frequent with more bits)");
        System.out.println("Encoded text with Huffman's method: " + huffman.encodedText());
        System.out.println("Number of Bits: " + huffman.encodedText().length());
        System.out.println(charArray.size() * 8);
        System.out.println(charArray.size() * 3);
        huffman.closeFile();
       
    }
    
}
