/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import SOOL.Aluno;
import SOOL.Emprestimo;
import SOOL.Livro;
import java.util.Date;

/**
 *
 * @author 18077
 */
public class PrincipalMain {

    public static void main(String[] args) {
        // Instancia as varias e inicializa as mesmas
        Aluno aluno = new Aluno();
        Livro livro = new Livro();

        // Adiciona Aluno para tese 
        aluno.setEndreco("Endereco Teste");
        aluno.setMatricula("123456");
        aluno.setNome("Fulano");

        // Adiciona livro para teste 
        livro.setQuantidade(2);
        livro.setTitulo("Livro de Teste");

        Date date = new Date();

        Emprestimo emprestimo = new Emprestimo(date, date, aluno, livro);

    }
}
