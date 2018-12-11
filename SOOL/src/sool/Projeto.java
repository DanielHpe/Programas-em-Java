/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.util.ArrayList;

/**
 *
 * @author danih
 */
public class Projeto {

    private String nome;
    private String descricao;
    private ArrayList<Curso> listaCursos = new ArrayList<>();

    // Método Construtor
    public Projeto(String nome, String descricao, ArrayList<Curso> listaCursos) {
        this.nome = nome;
        this.descricao = descricao;
        this.listaCursos = listaCursos;
    }

    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    public String getDescricao() {
            return descricao;
    }
    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }

    public ArrayList<Curso> getListaCursos() {
            return listaCursos;
    }
    public void setListaCursos(ArrayList<Curso> listaCursos) {
            this.listaCursos = listaCursos;
    }
    // Método utilizado para adicionar um curso de atuação ao projeto
    public void adicionarCurso(Curso curso){
            this.listaCursos.add(curso);
    }    
    
}
