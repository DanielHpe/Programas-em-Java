/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigohuffman;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Classe que faz a codificação de Huffman de um determinado texto
 * O texto é lido de um arquivo txt na raíz do programa
 * @author Daniel H. Pereira
 * 
 */
public class CodigoHuffman {
    
    public static List<Character> listCharacters = new ArrayList<>();
    private static final Map<Character, String> hashBits = new HashMap<>();
    public static Arvore root;
    public static HashMap<Character, Integer> hashCaracteres = new HashMap<>(); //Com ocorrência de cada caractere
    public static HashMap<Character, Double> hashProbabilidade = new HashMap<>();
    private RandomAccessFile instance_file;
    private static final int END_OF_FILE = -1; 
    private static int lookahead = 0;

    /**
     * Método construtor
     * @param caminho 
     */
    public CodigoHuffman(String caminho){
        
        try {
            instance_file = new RandomAccessFile(caminho, "r");
	} catch(IOException e) {
            System.out.println("Erro de abertura do arquivo " + caminho + "\n" + e);
            System.exit(1);
	}
        
    }
    
    /**
     * Método que fecha o arquivo após a leitura
     */
    public void fecharArquivo() {

        try {
            instance_file.close();
        }catch (IOException errorFile) {
            System.out.println ("Erro ao fechar arquivo\n" + errorFile);
            System.exit(3);
	}
    }
    
    /**
     * Método que lê o arquivo.txt por cada caractere
     * Após lido, o caractere (símbolo) é adicionado a lista de caracteres
     */
    public void leituraArquivo(){
        
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
            } else {
                listCharacters.add(c);
            }           
        }
        
    }
    
    /**
     * Método que monta a Hash de ocorrência de determinado símbolo no texto
     * O número de vezes que cada símbolo da Hash aparece. K -> símbolo | V -> ocorrência 
     */
    public void montarHashOcorrencia(){
        
        int i = 0;
        while(i < listCharacters.size()){
            hashCaracteres.put(listCharacters.get(i), retornaOcorrencia(listCharacters, listCharacters.get(i)));
            i++;
        }
        
    }
    
    /**
     * Método que monta a HashMap com as probabilidades de ocorrência de cada símbolo
     * O número de vezes que o símbolo aparece / o total de símbolos
     */
    public void montarHashProbabilidade(){
        
        hashCaracteres.entrySet().forEach((mEntry) -> {
            hashProbabilidade.put(mEntry.getKey().toString().charAt(0),
                    Math.round(Double.parseDouble(mEntry.getValue().toString()) / listCharacters.size()*100.0)/100.0);
        });     
        
    }
    
    /**
     * Método que codifica a árvore binária utilizando probabilidades
     * Estrutura Bottom-Up (De baixo para cima, da folha a raiz)
     */
    public void montarArvore(){
        
        PriorityQueue<Arvore> priorityQueue = new PriorityQueue<>();
        hashProbabilidade.keySet().stream().map((c) -> {
            Arvore arvore = new Arvore();
            arvore.simbolo = c;
            arvore.probabilidade = hashProbabilidade.get(c);
            return arvore;
        }).map((arvore) -> {
            arvore.esquerdo = null;
            return arvore;
        }).map((arvore) -> {
            arvore.direito = null;
            return arvore;
        }).forEachOrdered((arvore) -> {
            priorityQueue.offer(arvore);
        });
        assert priorityQueue.size() > 0;
        while (priorityQueue.size() > 1) {
            Arvore x = priorityQueue.peek();
            priorityQueue.poll();
            Arvore y = priorityQueue.peek();
            priorityQueue.poll();

            Arvore soma = new Arvore();
            soma.probabilidade = x.probabilidade + y.probabilidade;
            soma.simbolo = '-';
            soma.esquerdo = x;
            soma.direito = y;
            root = soma;

            priorityQueue.offer(soma);
        }     
    }  
    
    /**
     * Método que codifica a sequência de bits de cada símbolo do texto
     * @param node
     * @param codigo 
     */
    public void codificaArvore(Arvore node, StringBuilder codigo){
        
        if (node != null) {
            if (node.esquerdo == null && node.direito == null) {
		hashBits.put(node.simbolo, codigo.toString());
            } else {
		codigo.append('0');
		codificaArvore(node.esquerdo, codigo);
		codigo.deleteCharAt(codigo.length() - 1);
                codigo.append('1');
                codificaArvore(node.direito, codigo);
                codigo.deleteCharAt(codigo.length() - 1);
            }
	}
        
    }
    
    /**
     * Método que retorna o texto codificado através do algoritmo
     * @return 
     */
    public String codificaTexto(){
        
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < listCharacters.size(); i++) {
            char c = listCharacters.get(i);
            s.append(hashBits.get(c));
        }

        return s.toString(); 
        
    }
    
     /**
     * Método que organiza a Hash por ordem decrescente de probabilidade de ocorrência
     * @param <K>
     * @param <V>
     * @param map
     * @return 
     */
    public static <K, V> Map<K, V> organizaHashDecrescente(Map<K, V> map) {
        List<Entry<K,V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (Entry<K,V> o1, Entry<K,V> o2) -> ((Comparable<V>) ((Map.Entry<K, V>) (o2)).getValue())
                .compareTo(((Map.Entry<K, V>) (o1)).getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        list.forEach((entry) -> {
            result.put(entry.getKey(), entry.getValue());
        });

        return result;
    }
    
    /**
     * Método que retorna a ocorrência do caractere passado na lista de caracteres
     * @param list
     * @param character
     * @return 
     */
    public int retornaOcorrencia(List<Character> list, Character character){
        
        return Collections.frequency(list, character);
        
    }
    
    /**
     * Método principal
     * @param args 
     */
    public static void main(String[] args) {
        
        CodigoHuffman huffman = new CodigoHuffman("arquivo.txt");
        huffman.leituraArquivo();
        huffman.montarHashOcorrencia();
        huffman.montarHashProbabilidade();
        hashProbabilidade = (HashMap) organizaHashDecrescente(hashProbabilidade);
        huffman.montarArvore();
        huffman.codificaArvore(root, new StringBuilder());
        huffman.fecharArquivo();
        
        System.out.println("Texto a ser codificado: " + listCharacters);
        System.out.println("Hash de probabilidades de ocorrência: " + hashProbabilidade);
        System.out.println("Sequência de bits de cada símbolo: " + (hashBits));
        System.out.println("Texto codificado: " + huffman.codificaTexto());
        System.out.println("Número de bits: " + huffman.codificaTexto().length());
        System.out.println("Número de bits (ASCII): " + listCharacters.size() * 8);
        
    }
    
}
