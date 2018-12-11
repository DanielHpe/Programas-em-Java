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
class Instituto {

    private String sigla;
    private String nome;
    private ArrayList<Coordenador> listaCoordenadores;	
    
    public Instituto(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
        this.listaCoordenadores = new ArrayList<Coordenador>();		
    }
    
    public String getSigla() {
            return sigla;
    }
    public void setSigla(String sigla) {
            this.sigla = sigla;
    }
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    // Metodo para instanciar um novo coordenador e adiciona-lo em uma lista //
    public void addCoordenador(String nome, String titulacao, String CPF, int cargaHoraria, Emprestimo bonus) {
            Coordenador c = new Coordenador(nome, titulacao, CPF, cargaHoraria, bonus);
            listaCoordenadores.add(c);
    }    
}
