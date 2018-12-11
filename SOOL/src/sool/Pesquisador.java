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
public class Pesquisador extends Professor{
    
    // Atributos
    private int cargaHoraria;
    // Lista de projetos
    private ArrayList<Projeto> listaProjetos;

    // Método Construtor
    public Pesquisador(int cargaHoraria, ArrayList<Projeto> listaProjetos, String nome, String titulacao, String CPF) {
            super(nome, titulacao, CPF);
            this.cargaHoraria = cargaHoraria;
            this.listaProjetos = listaProjetos;
    }	

    public int getCargaHoraria() {
            return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Projeto> getListaProjetos() {
            return listaProjetos;
    }
    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
            this.listaProjetos = listaProjetos;
    }

    // Método para adicionar um projeto para o pesquisador
    public void adicionarProjeto(Projeto projeto, String nome, String descricao, ArrayList<Curso> listaCursos){
            projeto = new Projeto(nome, descricao, listaCursos);
            listaProjetos.add(projeto);
    }

    // Método para pesquisar se um pesquisador está alocado em um determinado projeto
    public boolean buscarPesquisador(String CPF, String nomeProjeto){
        if(getCargaHoraria() == 0){			
            return false;
        }else{
            for(int i = 0; i < listaProjetos.size(); i++){
                if(getCPF().equals(CPF)){
                        return true;
                }
            }
            return false;
        }
    }		

}
