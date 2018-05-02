/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Stack;

/**
 *
 * @author daniel
 */

public class Parser extends ParsingTable {
    
    private final Lexer lexer;
    private Token token;
    private String resultado = "";
    private String resultadoParser = "";
    private String nextToken;
    private String top;
    private javax.swing.JTextArea textArea1;
    private javax.swing.JTextArea textArea2;
    private javax.swing.JTextArea textArea3;
    private Stack<String> pilha = new Stack<>();
    
    public boolean synch = false;
    public boolean skip = false;
    
    public Parser(Lexer lexer, javax.swing.JTextArea txA1, javax.swing.JTextArea txA2
                    ,  javax.swing.JTextArea txA3){
        this.lexer = lexer;
        this.token = lexer.proxToken();
        this.textArea3 = txA3;
    }
    
    // Parser Não Recursivo
    public void nonRecursiveParser(){
        
//        push(token.getLexema());
        push("prog");
        
        top = null;
        
        nextToken = token.getLexema();
        
        do{
            top = pop();
            getTokenByRegra(top, token);
            
            if(isNonTerminal(top)){
                String rule = this.getRegra(top, token.getLexema());
                this.pushRegra(rule);
            } else if(isTerminal(top)){
                System.out.println("Matching terminal: ( " + nextToken + " )");
                resultadoParser += "Matching terminal: ( " + nextToken + " )\n";
                nextToken = getNextToken();
                textArea3.setText(resultadoParser);   
            }
            
            if(nextToken.equals("EOF")){
                resultadoParser += "Matching terminal: (" + nextToken + ")\n";
                textArea3.setText(resultadoParser);
                break; //Fim da análise sintática
            }
            
            
        } while(true);
        
        
    }
    
    //  Alterando o Lexema caso o TOKEN case com o topo pra avanço da entrada
    //  (Exemplo: se lexema for "varchar", logo, lexema é um id, para comparação
    /*
        Topo da Pilha:
        'literal' para qualquer ASCII entre aspas duplas
        'id' para qualquer palavra começando com letra seguido de letra ou número
        'num_const' para qualquer número (double ou inteiro)
        'char_const' para qualquer caractere ASCII entre aspas simples    
    */
    
    public void getTokenByRegra(String top, Token token){
        
        if(token.getClasse().equals(Tag.ID)){
            token.setLexema("id");
        } else if(token.getClasse().equals(Tag.LIT)){
            token.setLexema("literal");    
        } else if (token.getClasse().equals(Tag.num_const)){
            token.setLexema("num_const");            
        } else if (token.getClasse().equals(Tag.char_const)){
            token.setLexema("char_const");         
        }
        
    }
    
    // Empilha regra da gramática na pilha (ao inverso)
    private void pushRegra(String regra){
        
        //Divide a string contendo a regra em um array
        String[] splitRegra = regra.split("\\s+");
        
        for(int i = splitRegra.length - 1; i >= 0; i--){
            String regraAt = splitRegra[i];
            push(regraAt);
        }
        
    }
    
    // Verifica se elemento do topo é um terminal
    private boolean isTerminal(String s){
        
        for(int i = 0; i < terminals.length; i++){
            if(s.equals(terminals[i])){
                return true;
            }
        }
        
        return false;
    }
    
    // Verifica se elemento do topo é um não-terminal
    private boolean isNonTerminal(String s){
        
        for(int i = 0; i < nonTerminals.length; i++){
            if(s.equals(nonTerminals[i])){
                return true;
            }
        }
        
        return false;
    }
    
    // Advance
    // Recebe o próximo Token
    private String getNextToken(){
        
        token = lexer.proxToken();
        String tokenLexema = token.getLexema();
        
        return tokenLexema;
        
    }
   
    // Empilha elemento no topo da pilha
    private void push(String s){
        this.pilha.push(s);
    }
    
    // Desempilha elemento do topo
    private String pop(){
        return this.pilha.pop();
    }
    
    // Exibe mensagem de erro
    private void exibeErro(String message){
        resultadoParser += message + "\n";
        System.out.println(resultadoParser);
        textArea3.setText(resultadoParser);
    }
    
    // Recupera a regra da tabela conforme o index[nonTerm][term]
    private String getRegra(String nonTerminal, String terminal){
        
        int row = getNonTerminalIndex(nonTerminal);
        int column = getTerminalIndex(terminal);
        
        String regra = preditiveTable[row][column];
        
        if(regra.equals("synch")){
            synch();
        } else if(regra.equals("skip")){
            skip();
        } 
        
        return regra;
    }
    
    // Recupera o index do não terminal de interesse
    private int getNonTerminalIndex(String nonTerminal){
                
        for(int i = 0; i < nonTerminals.length; i++){
            if(nonTerminal.equals(nonTerminals[i])){
                return i;
            }
        }
        
        exibeErro(nonTerminal + " não é um nonTerminal");
        
        return -1;
    }
    
    // Recupera o index do terminal de interesse
    private int getTerminalIndex(String terminal){
        
        for(int i = 0; i < terminals.length; i++){
            if(terminal.equals(terminals[i])){
                return i;
            }
        }
        
        exibeErro(terminal + " não é um Terminal");
        
        return -1;
    }
    
    private void synch(){
        exibeErro("Synch. Token Inesperado: " + nextToken);
        pop();
    }
    
    private void skip(){
        exibeErro("Skip. Token Inesperado: " + nextToken);
        nextToken = getNextToken();
    }
    
}
   


