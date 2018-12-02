/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shiftand;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import static java.nio.charset.StandardCharsets.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Daniel H. Pereira
 */
public class ShiftAnd {

    /**
     * @param args the command line arguments
     */

    /**
     * Atributos
     */
    public static Map<Integer, Estados> states = new HashMap<>();;
    private RandomAccessFile instance_file;
    private static final int END_OF_FILE = -1; 
    private static int lookahead = 0;
    
    /**
     * Construtor da classe
     * @param input_data é o caminho do arquivo txt a ser lido
     */
    public ShiftAnd(String input_data){
        
        try {
            instance_file = new RandomAccessFile(input_data, "r");
	} catch(IOException e) {
            System.out.println("Erro de abertura do arquivo " + input_data + "\n" + e);
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
     * Método que faz a leitura do arquivo.txt 
     * Cada caractere lido é adicionado na String texto
     * * Caso leitura encontra \n (Quebra de linha), é adicionado a texto um espaço ' ' pois
     * * quebras de linha não estavam sendo reconhecidas no método "transitions"
     * @return 
     */
    public String readText(){
       
        StringBuilder texto = new StringBuilder();
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
            } else if (c == '\t' || c == '\n' || c == '\r'){
                texto.append(' ');
            } else {
                texto.append(c);
            }
            
        }
        
        return texto.toString();
    }
    
    /**
     * Método que monta as transições do AFN
     * Enquanto o padrão não é encontrado, mantém-se o estado 0 (inicial)
     * Caso a primeira letra do padrão case com 1 letra da entrada, o automato avança
     * Se não chega no estado final (pós última letra do padrão), o padrão não existe no texto
     * Exemplo: Texto: Testa e padrão: Teste, o automato lê o último caractere e não avança ao estado final
     */
    public Map<Integer, Estados> transitions(String texto, String padrao){
        
        int i = 0;
        int j = 0;
        int codEstados = 1;

        // Inserção do padrão na Hash de estados só acontece 1 vez
        // Quando automato chega no estado final (padrão existe no texto), executaProcesso = 1
        int executaProcesso = 0; 

        Map<Integer, Estados> states = new HashMap<>();
        
        Estados q0 = new Estados(false);
        q0.addTransition(texto.charAt(0), 0);
        states.put(0, q0);
        
        Estados qNew;
        Estados qFinal;
        
        // Percorre todo o texto lido
        for(i = 0; i < texto.length(); i++){
            if(texto.charAt(i) != padrao.charAt(j)){ // Se texto na posição i não casa com padrão na posição j
                q0.addTransition(texto.charAt(i), 0); // Permanece no estado 0
                states.put(0, q0);
                j = 0;
                codEstados = 1;
            } else {
                if(executaProcesso == 0){ // Executa caso executaProcesso seja igual a 0
                    if(texto.charAt(i) == padrao.charAt(j)){ // Se texto na posição i casa com padrão na posição j
                        if(j == padrao.length() - 1){ // E padrão não está em seu último caractere
                            qFinal = new Estados(true); // Caso último caractere no padrão, adiciona estado final
                            qFinal.addTransition(texto.charAt(i), codEstados);
                            states.put(codEstados, qFinal);
                            executaProcesso = 1;
                            j = 0;
                        } else {
                            qNew = new Estados(false); // Novo estado é adicionado ao automato
                            qNew.addTransition(padrao.charAt(j), codEstados); 
                            states.put(codEstados, qNew);
                            j++;
                            codEstados++;
                        }
                    }
                }
            }
        }

        return states;
        
    }  
       
    /**
     * Método que formata a leitura da saída "Estado: qNumeroDoEstado - "
     * @param state
     * @return 
     */
    private String formatState(Integer state){
        if((states.size() < 100) && (state < 10)){
            return "\nEstado: q" + state + "  - ";
        }

        return "\nEstado: q" + state + " - ";
    }
    
    /**
     * Método que simula o funcionamento do automato finito não-determinístico em cima do texto lido
     * Caso caractere lido do texto case com o caractere lido do padrão, automato avança
     * O estado final corresponde ao último caractere do padrão
     * Se automato chega no estado final, retorna "- ACEITA" (encontrou o padrão) e número de padrões encontrados recebe +1
     * @param texto
     * @param padrao
     * @param states
     * @return 
     */
    public int afn(String texto, String padrao, Map<Integer, Estados> states){
        
        String input = texto;
        Integer state = 0;
        Integer j = 0;
        int length = input.length();
        int numeroVezesEncontrado = 0;

        System.out.println("\n1. Ao ler o caractere entre [], o automato vai pro próximo estado determinado");
        System.out.println("2. Automato avança a cada caractere do padrão encontrado. Caso não encontre, volta ao estado 0");
        
        for(int symbol = 0; symbol < length; symbol++){
            
            System.out.print(formatState(state));
            
            for(int index = 0; index < length; index++){
                if(index != symbol){
                    System.out.print(" " + input.charAt(index) + " ");
                } else{
                    System.out.print("[" + input.charAt(index) + "]");
                }
            }
            
            if(j != padrao.length()){
                if(input.charAt(symbol) == padrao.charAt(j)){
                    state++;
                    j++;
                } else {
                    j = 0;
                    state = 0;
                } 
            } else {
                j = 0;
                state = 0;
            }
            
            state = states.get(state).getTransition(input.charAt(symbol));
            
            if(state == null){               
                System.out.println(" - REJEITA");
                return 0;
            }
            
            if(states.get(state).isAccept()){
                System.out.print(" - ACEITA");
                numeroVezesEncontrado++;
            } 

        }
        
        if(numeroVezesEncontrado == 0){
            System.out.print(" - REJEITA");
        }

        return numeroVezesEncontrado;
   
    }
    
    /**
     * Método principal 
     * Instancia o construtor da classe passando o caminho do texto como parâmetro
     * Imprime as saídas do programa (O trajeto do automato e o número de vezes que o padrão foi encontrado)
     * @param args
     * @throws UnsupportedEncodingException 
     */
    public static void main(String[] args) throws UnsupportedEncodingException {

        ShiftAnd shift = new ShiftAnd("texto.txt");
        String texto = new String(shift.readText().getBytes(ISO_8859_1), UTF_8);
        String padrao = "nova";
        
        states = shift.transitions(texto, padrao);  
        
        System.out.println("Algoritmo de pesquisa de cadeias de caracteres. \n");
        System.out.println("Texto (Entrada): " + texto);
        System.out.println("Padrão a ser buscado: " + padrao);    
        System.out.print("--------------------------------------------------------------------------------------------------------------------------");   
        if(padrao.length() > texto.length()){
            System.out.println("\n\nPadrão a ser buscado não pode ser maior que o texto de entrada\n");
        } else {   
            if(states != null){
                System.out.println("\n\nO padrâo a ser buscado foi encontrado " + shift.afn(texto, padrao, states) + " vez(es)!");    
            } else {
                System.out.println("\nPadrão não encontrado no texto!");
            }   
        }    
        System.out.println("--------------------------------------------------------------------------------------------------------------------------"); 
        shift.fecharArquivo();
        
    }
}
