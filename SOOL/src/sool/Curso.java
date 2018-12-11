/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author danih
 */
public class Curso implements Serializable {
    
    private String codigo;
    private String nome;
    private String turno;
    
    private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    private ArrayList<Instituicao> listaInstituicoes = new ArrayList<>();
    private ArrayList<Projeto> listaProjetos = new ArrayList<>();
    
    public Curso (String codigo, String nome, String turno){
        this.codigo = codigo;
        this.nome = nome;
        this.turno = turno;
        
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void adicionarInstituicao(Instituicao instituicao) {
	this.listaInstituicoes.add(instituicao);
    }
    
    public void removerInstituicao(String nome){
		listaInstituicoes.remove(nome);
    }
    
     
    public void excluirAluno(String matricula){
        listaAlunos.remove(matricula);
    }
    
    //Método para adicionar um projeto o curso
    public void adicionarProjetoNoCurso(Projeto projetos){
         listaProjetos.add(projetos);
    }
    
}
