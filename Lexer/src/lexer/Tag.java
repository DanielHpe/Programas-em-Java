/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author daniel
 */
public enum Tag {
    
    // fim de arquivo
    EOF,
    
    //Operadores
    OP_LT,
    OP_LE,
    OP_GT,
    OP_GE,
    OP_EQ,
    OP_NE,
    OP_ASS,
    OP_AD,
    OP_MIN,
    OP_MUL,
    OP_DIV,
    
    //Simbolos
    SMB_OBC,
    SMB_CBC,
    SMB_OPA,
    SMB_CPA,
    SMB_COM,
    SMB_SEM,
    
    //identificador
    ID,
    
    //numeros
    num_const,
    
    //String em aspas simples
    //strings
    char_const,
    
    //String em aspas duplas
    LIT,
    
    // palavra reservada
    KW,
    
    //Comentário de 1 Linha // (NÃO É TOKEN)
    comentarioLinha,
    
    //Comentário Extenso // (NÃO É TOKEN)
    comentarioExtenso
    
      
}
