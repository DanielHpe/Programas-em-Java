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
public class Campus {
    
    // Atributos
    private int nome;
    private int quantBlocos;
    private ArrayList<Instituto> listaInstitutos;

    // Método Construtor
    public Campus(int nome, int quantBlocos) {
            this.nome = nome;
            this.quantBlocos = quantBlocos;

    }

    // Métodos para atualizar e obter atributos da classe (getters and setters)
    public int getNome() {
            return nome;
    }
    public void setNome(int nome) {
            this.nome = nome;
    }
    public int getQuantBlocos() {
            return quantBlocos;
    }
    public void setQuantBlocos(int quantBlocos) {
            this.quantBlocos = quantBlocos;
    }

    public ArrayList<Instituto> getListaInstituto() {
            return listaInstitutos;
    }
    public void setListaInstituto(ArrayList<Instituto> listaInstituto) {
            this.listaInstitutos = listaInstituto;
    }	

    // Método utilizado para adicionar um instituto ao campus
    public void adicionarInstituto(Instituto instituto){
            listaInstitutos.add(instituto);
    }



}
