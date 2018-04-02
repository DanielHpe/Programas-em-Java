/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

/**
 *
 * @author danih
 */
public class LexerTeste {
    
    TS tabelaSimbolos;
    
    int n_line = 1;
    int n_column = 1;
    
    //Reporta erro para o usuário
    public void sinalizaErro(String mensagem) {
        System.out.print("[Erro Lexico]: " + mensagem + "\n");
    }
    
    public void avancaPonteiro(){
        
        
        
        
    }
    
    //Volta uma posição do buffer de leitura
    public void retornaPonteiro(){
        
        
    }
    
    public Token proxToken(String word) {

	StringBuilder lexema = new StringBuilder();
	int estado = 1;
	Character c;
        
        c = '\u0000'; // null char
		
	for(int i = 0; i < word.length(); i++) {
            
            c = word.charAt(i);
            
            // movimentacao do automato
            switch(estado) {
                case 1:
                    if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                        // Permance no estado = 1
                        if(c == '\n')  {
                            
                        }
                        else if(c == '\t') {
                           
                        }
                    }
                    else if (Character.isLetter(c)){
                        lexema.append(c);
                        estado = 14;
                    }
                    else if (Character.isDigit(c)) {
                        lexema.append(c);
                        estado = 12;
                    }
                    else if (c == '<') {
                        estado = 6;
                    }
                    else if (c == '>') {
                        estado = 9;
                    }
                    else if (c == '=') {
                        estado = 2;
                    }
                    else if (c == '!') {
                        estado = 4;
                    }
                    else if (c == '/') {
                        estado = 16;
                    }
                    else if (c == '*') {
                        estado = 18;
                        return new Token(Tag.OP_MUL, "*", n_line, n_column);
                    }
                    else if(c == '+') {
                        estado = 19;
                        return new Token(Tag.OP_AD, "+", n_line, n_column);
                    }
                    else if(c == '-') {
                        estado = 20;
                        return new Token(Tag.OP_MIN, "-", n_line, n_column);
                    }
                    else if(c == ';') {
                        estado = 21;
                        return new Token(Tag.SMB_SEM, ";", n_line, n_column);
                    }
                    else if(c == '(') {
                        estado = 22;
                        return new Token(Tag.SMB_OPA, "(", n_line, n_column);
                    }
                    else if(c == ')') {
                        estado = 23;
                        return new Token(Tag.SMB_CPA, ")", n_line, n_column);
                    }
                    else if(c == '{') {
                        estado = 30;
                        return new Token(Tag.SMB_OBC, "{", n_line, n_column);
                    }
                    else if(c == '}'){
                        estado = 31;
                        return new Token(Tag.SMB_CBC, "}", n_line, n_column);
                    } 
                    else if( c == ','){
                        estado = 33;
                        return new Token(Tag.SMB_COM, ",", n_line, n_column);
                    }
                    else if(c == '"') {
                        estado = 24;
                    }                    
                    else {
                        sinalizaErro("Caractere invalido " + c + " na linha " + n_line + " e coluna " + n_column); 
                    }
                    break;
                case 2:
                    if (c == '=') { // Estado 3
                        estado = 3;
                        return new Token(Tag.OP_EQ, "==", n_line, n_column);
                    }
                    else {
                        retornaPonteiro();
                        return new Token(Tag.OP_ASS, "=", n_line, n_column);
                    }
		case 4:
                    if (c == '=') { // Estado 5
                        estado = 5;
			return new Token(Tag.OP_NE, "!=", n_line, n_column);
                    }
                    else {
                        avancaPonteiro();
                        sinalizaErro("Token incompleto para o caractere ! na linha " + n_line + " e coluna " + n_column);
//                        lexema.append(c);
//                        return null;

                    }
                case 6:
                    if (c == '=') { // Estado 7
                        estado = 7;
			return new Token(Tag.OP_LE, "<=", n_line, n_column);
                    }
                    else { // Estado 8
                        estado = 8;
			retornaPonteiro();
			return new Token(Tag.OP_LT, "<", n_line, n_column);
                    }
                case 9:
                    if (c == '=') { // Estado 10
                        estado = 10;
                        return new Token(Tag.OP_GE, ">=", n_line, n_column);
                    }
                    else { // Estado 11
                        estado = 11;
                        retornaPonteiro();
                        return new Token(Tag.OP_GT, ">", n_line, n_column);
                    }
                case 12:
                    if (Character.isDigit(c)) {
                        lexema.append(c);
                        // Permanece no estado 12
                    }
                    else if (c == '.') {
                        lexema.append(c);
                        estado = 26;
                    }
                    else { // Estado 13
                        estado = 13;
                        retornaPonteiro();						
			return new Token(Tag.num_const, lexema.toString(), n_line, n_column);
                    }
                    break;
		case 14:
                    if (Character.isLetterOrDigit(c) || c == '_') {
                        lexema.append(c);
			// Permanece no estado 14
                    }
                    else { // Estado 15
                        estado = 15;
                        Token token = tabelaSimbolos.retornaToken(lexema.toString());
                        
                        if (token == null) {
                            return new Token(Tag.ID, lexema.toString(), n_line, n_column);
                        }
                        return token;
                    }
                    break;
                case 16:
                    if (c == '/') {
                        estado = 17;
                    } else if (c == '*'){
                        estado = 18;
                    }
                    else {
                        retornaPonteiro();
			return new Token(Tag.OP_DIV, "/", n_line, n_column);
                    }
                    break;
                case 17:
                    if (c == '\n') {
                        estado = 34;
                        return new Token(Tag.comentarioLinha, "Comentário", n_line, n_column);
                    } else {
                        lexema.append(c); 
                    }
                    // Se vier outro, permanece no estado 17
                    break;
                    
                case 18:
                    if(c == '*'){
                        estado = 19; 
                    } 
//                    else if (lookahead == END_OF_FILE) {
//                        sinalizaErro("Comentário deve ser fechado com */ antes do fim do arquivo");
//                        avancaPonteiro();
//                        return null;
//                    } else {
                        lexema.append(c);
                    
                    break;
                case 19:
                    if(c == '/'){
                        estado = 20;
                    } 
//                    else if (lookahead == END_OF_FILE) {
//                        sinalizaErro("Comentário deve ser fechado com */ antes do fim do arquivo");
//                        return null;
//                    }
                    else if(c == '*') {
                        estado = 19;
                    } else {
                        lexema.append(c);
                    }
                    break;
                case 20:
                    estado = 21;
                    // Não é Token, mas é retornado para reiniciar o loop
                    return new Token(Tag.comentarioExtenso, "Comentário", n_line, n_column);  
                case 24:
                    if (c == '"') {
                        estado = 25;
                        return new Token(Tag.LIT, lexema.toString(), n_line, n_column);
                    }
//                    else if (lookahead == END_OF_FILE) {
//                        sinalizaErro("String deve ser fechada com \" antes do fim de arquivo");
//			return null;
//                    }
                    else { // Se vier outro, permanece no estado 24
                        lexema.append(c);
                    }
                    break;
                case 26:
                    if (Character.isDigit(c)) {
                        lexema.append(c);
                        estado = 27;
                    }
                    else {
                        sinalizaErro("Padrao para double invalido na linha " + n_line + " coluna " + n_column);
			return null;
                    }
                    break;
                case 27:
                    if (Character.isDigit(c)) {
                        lexema.append(c);
                    }
                    else {
                        retornaPonteiro();						
			return new Token(Tag.num_const, lexema.toString(), n_line, n_column);
                    }
            }
        }
        
        return null;
        
    }
    
    public String readStringTeste(String word, int i, int length){
             
        Token token;
        tabelaSimbolos = new TS();
        
        if(word.contains("/*")){

            while(!word.equals("*/")){
                i++;
                if(i == length){
                    i = i - 1;
                    return "Erro Léxico: COMENTARIO NAO FECHADO";
                }                    
            }

        } else if (word.contains("\""))  {

            while(!word.equals("\"")){
                i++;
                if(i == length){
                    i = i - 1;
                    return "Erro Léxico: STRING NAO FECHADA";
                }                    
            }  

        } else {

            token = this.proxToken(word + " ");
            // Imprime token
            if(token != null ) {

                return "Token: " + token.toString();

            } else {

                return "";

            }  

        } 
        
        token = this.proxToken(word + " ");
        
        // Imprime token
        if(token != null && token.getClasse() != Tag.comentarioExtenso && token.getClasse() != Tag.comentarioLinha) {

            return "Token: " + token.toString();

        } else {
            
            return "";
            
        }
    }
    
    
    public void readString(String s){
        
        Token token;
        tabelaSimbolos = new TS();
        
        String[] words = s.split("\\s+");
        
        for(int i = 0; i < words.length; i++){
          
            token = this.proxToken(words[i] + " ");

            // Imprime token
            if(token != null && token.getClasse() != Tag.comentarioExtenso && token.getClasse() != Tag.comentarioLinha) {
                
                System.out.println("Token: " + token.toString() + "\t Linha: " + n_line + "\t Coluna: " + n_column);
                
            } else {
                
                System.out.println("");
                
            }
                       
        }
        
    }

}
