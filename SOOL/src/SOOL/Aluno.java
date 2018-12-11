/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danih
 */
public class Aluno implements Serializable {
 
    private String matricula;
    private String nome;
    private String endereco;
    private Ciclo ciclo;
    private Curso curso;
    private Disciplina discplina;
    private Turma turma;
    public static ArrayList<Aluno> alunos = new ArrayList<>();
    
    public Aluno(String matricula, String nome, String endereco,
            Ciclo ciclo, Curso curso, Disciplina d, Turma t){
        this.matricula = matricula;
        this.nome = nome;
        this.endereco = endereco;
        this.ciclo = ciclo;
        this.curso = curso;
        this.discplina = d;
        this.turma = t;
        alunos.add(this);
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public Disciplina getDiscplina() {
        return discplina;
    }

    public Turma getTurma() {
        return turma;
    }
    
    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
            return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public static void removeAlunos(Ciclo cl, Curso c, Disciplina d, Turma t){
        for(Aluno a : alunos){
            if(a.getCiclo().equals(cl) && a.getCurso().equals(c)
                    && a.getDiscplina().equals(d) && a.getTurma().equals(t)){
                alunos.remove(a);
                System.out.println("Alunos removidos");
                break;
            }
        }
    }
   
}
