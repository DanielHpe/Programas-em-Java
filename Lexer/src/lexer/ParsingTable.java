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

public class ParsingTable {
    
    //Tabela Preditiva   
    String [][] preditiveTable =
    {
        {   "program id body", "skip", "skip", "skip", "skip", "skip", "skip", "skip",
            "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", 
            "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip",
            "skip", "skip", "skip", "skip", "skip", "skip", "synch"}, 
        
        {   "skip", "skip", "decl-list { stmt-list }", "skip", "skip", "decl-list { stmt-list }", "decl-list { stmt-list }",
         	"skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip",
            "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", 
            "skip", "skip", "skip", "skip", "skip", "skip", "skip", "skip", "ε"},
        
        {   "skip", "skip", "ε", "skip", "skip",  "decl ; decl-list", "decl ; decl-list", 
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "synch",  "type id-list", "type id-list",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip", 
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "synch",  "skip",  "skip",  "skip",  "num",  "char", "skip",  "skip", 
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip", 
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "id id-listLINHA", "skip",  "skip",  "synch",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"},
        
        {   "skip",  "skip",  "skip",  "skip",  "ε", "skip",  "skip",  ", id-list", "skip", 
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip"},  
        
        {   "skip",  "stmt ; stmt-list",     "skip",  "ε",  "skip",  "skip",  "skip",  "skip",
            "skip",  "stmt ; stmt-list",     "skip",  "skip",  "skip",  "stmt ; stmt-list", 
            "stmt ; stmt-list", "stmt ; stmt-list", "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "assign-stmt", "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",
            "if-stmt", "skip",  "skip",  "skip",  "while-stmt", "read-stmt", "write-stmt", "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "id = simple-expr",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",    "skip",    "skip",    "skip",    "synch",    "skip",    "skip",    "skip",
            "skip",    "if ( condition ) { stmt-list } if-stmtLINHA",  "skip",    "skip",    "skip",
            "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",
            "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip",    "skip"},
        
        {   "skip",  "skip",  "skip",  "skip",  "ε", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "else { stmt-list }", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip","skip",  "skip",  "skip",  "skip",  "skip",  "skip"},
        
        {   "skip",  "expression", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "expression", "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "expression",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "expression", "expression", "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "stmt-prefix { stmt-list }", "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "while ( condition )", "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "read id", "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "write writable", "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "simple-expr",  "skip",  "skip",  "synch",  "skip",  "skip", "skip",  "skip",
            "skip",  "simple-expr",  "skip",  "skip",  "skip",  "skip",
            "skip",  "literal", "simple-expr",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "simple-expr",  "simple-expr",  "skip"},  
        
        {   "skip",  "simple-expr expressionLINHA", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "simple-expr expressionLINHA", "synch", "skip",  "skip",  "skip",  "skip",
            "skip",  "simple-expr expressionLINHA", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "simple-expr expressionLINHA", "simple-expr expressionLINHA", "skip"},
        
        {   "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "ε", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "relop simple-expr", 
            "relop simple-expr",  "relop simple-expr",  "relop simple-expr",  "relop simple-expr",  "relop simple-expr",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "term simple-exprLINHA", "skip",  "skip",  "synch",  "skip",  "skip",  "skip",
            "skip",  "skip",  "term simple-exprLINHA", "synch",  "skip",  "skip",  "skip",  "skip",  "skip",
            "term simple-exprLINHA", "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "term simple-exprLINHA", "term simple-exprLINHA", "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "ε", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "ε",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "ε", "ε", "ε", "ε", "ε", "ε", "addop term simple-exprLINHA",
            "addop term simple-exprLINHA", "addop term simple-exprLINHA", "skip",  "skip",  "skip",  "skip",  "skip",  "skip"}, 
        
        {   "skip",  "factor-a termLINHA", "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",
            "skip",  "factor-a termLINHA", "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "factor-a termLINHA",
            "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "skip",
            "skip",  "skip",  "factor-a termLINHA", "factor-a termLINHA", "skip"},
        
        {   "skip",  "skip",  "skip",  "skip",  "ε", "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "ε",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "ε", "ε", "ε", "ε", "ε", "ε", "ε", "ε", "ε",
            "mulop factor-a termLINHA", "mulop factor-a termLINHA", "mulop factor-a termLINHA", "skip",  "skip",  "skip"}, 
        
        {   "skip",  "factor",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "factor",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "not factor", "synch",  "synch",  "synch",  "synch",
            "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "factor",  "factor",  "skip"},
        
        {   "skip",  "id", "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "( expression )",
            "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "synch",  "synch",  "synch",
            "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "constant", "constant", "skip"},
        
        {   "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "==", ">", ">=", "<", "<=", "!=",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "synch",  "skip"},
        
        {   "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip", 
            "skip",  "skip",  "skip",  "skip",  "+", "-", "or", "skip",  "skip",  "skip",  "synch",  "synch",  "skip"}, 
        
        {   "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",
            "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",
            "skip",  "skip",  "skip",  "skip",  "skip",  "*", "/", "and", "synch",  "synch",  "skip"}, 
        
        {   "skip",  "skip",  "skip",  "skip",  "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",
            "synch",  "skip",  "skip",  "skip",  "skip",  "skip",  "skip",  "synch",  "synch",  "synch",  "synch",
            "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "synch",  "num_const", "char_const", "skip"}   
    
    };
    
    //Não Terminais da Gramática
    static String[] nonTerminals = {"prog", "body", "decl-list", "decl", "type", "id-list", "id-listLINHA", "stmt-list", 
                                    "stmt", "assign-stmt", "if-stmt", "if-stmtLINHA", "condition", 
                                    "while-stmt", "stmt-prefix", "read-stmt", "write-stmt", "writable", "expression",
                                    "expressionLINHA", "simple-expr", "simple-exprLINHA", "term", "termLINHA", "factor-a",
                                    "factor", "relop", "addop", "mulop", "constant"};
    
    //Terminais da Gramática
    static String[] terminals = {"program", "id", "{", "}", ";", "num", "char", ",", "=", "if", "(", ")", "else", "while",
                                "read", "write", "literal", "not", "==", ">", ">=", "<", "<=", "!=", "+", "-", "or", "*",
                                "/", "and", "num_const", "char_const", "$"};    
    
}
