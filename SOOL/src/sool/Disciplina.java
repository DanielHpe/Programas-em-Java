/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;


public class Disciplina implements Serializable{
    
    private final String codigo;
    private final String nome;
    private final int cargaHoraria;
    private final int quantCreditos;
    private final int quantMinCreditos;
    public Ciclo ciclo;
    public Curso curso;
    public static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Disciplina (String codigo, String nome,
            int cargaHoraria, int quantCreditos, int quantMinCreditos,
            Ciclo ciclo, Curso curso){
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.quantCreditos = quantCreditos;
        this.quantMinCreditos = quantMinCreditos;
        this.ciclo = ciclo;
        this.curso = curso;
        disciplinas.add(this);
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getCodigo(){
            return codigo;
    }

    public String getNome(){
            return nome;
    }

    public int getCargaHoraria(){
            return cargaHoraria;
    }

    public int getQuantCreditos(){
            return quantCreditos;
    }

    public int getQuantMinCreditos(){
            return quantMinCreditos;
    }
    
    public static void removeDisciplinas(Curso c, Ciclo cl, boolean isGraduacao){
        for(Disciplina d : disciplinas){
            if(d.getCiclo().equals(cl) && d.getCiclo().getCurso().equals(c)){
                disciplinas.remove(d);
                if(isGraduacao){
                    TurmaGraduacao.removeTurma(cl, c, d);
                } else {
                    TurmaExtensao.removeTurma(cl, c, d);
                }
                System.out.println("Disciplina removida");
                break;
            }
        }
    }

}
    
