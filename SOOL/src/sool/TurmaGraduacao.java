/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;

public class TurmaGraduacao extends Turma implements Serializable{
    
    public int semestre;
    public int ano;
    public static ArrayList<TurmaGraduacao> turmas = new ArrayList<>();
    public Curso curso;
    public Ciclo ciclo;
    public Disciplina disciplina;
    
    public TurmaGraduacao(int codSequencia, 
            int semestre, int ano, 
            Ciclo ciclo, Curso curso, Disciplina disciplina) {
        super(codSequencia);
        this.semestre = semestre;
        this.ano = ano;
        this.ciclo = ciclo;
        this.curso = curso;
        this.disciplina = disciplina;
        turmas.add(this);
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public boolean pesquisaAlunoInscritoNaTurma(String codigoTurma){
        
        for (Aluno a : listaAlunos) 
             if (a.getMatricula() == codigoTurma) {
                return true;
        }

        return false;
    }
    
    public static void removeTurma(Ciclo cl, Curso c, Disciplina d){
        for(TurmaGraduacao tg : turmas){
            if(tg.getCiclo().equals(cl) && tg.getCiclo().getCurso().equals(c)
                        && tg.getDisciplina().equals(d)){
                turmas.remove(tg);
                Aluno.removeAlunos(cl, c, d, tg);
                System.out.println("Turma removida");
                break;
            }
        }
    }
    
}
