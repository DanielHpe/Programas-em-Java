/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOOL;

/**
 *
 * @author 18077
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String endreco;
    //private ArrayList<Turma> listaTurma;

    public Aluno() {
        this.matricula = null;
        this.nome = null;
        this.endreco = null;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndreco() {
        return endreco;
    }

    public void setEndreco(String endreco) {
        this.endreco = endreco;
    }

}
