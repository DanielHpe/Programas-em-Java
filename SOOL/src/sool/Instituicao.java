/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author danih
 */
class Instituicao {
    
    // Atributos
    private String nome;
    private String cidade;
    private String UF;
    // Listas de campus e cursos
    private ArrayList<Campus> listaCampi;
    private ArrayList<Curso> listaCursos;
    Scanner c = new Scanner(System.in);
    private Campus campus;

    // Método Construtor
    public Instituicao(String nome, String cidade, String UF) {
        this.nome = nome;
        this.cidade = cidade;
        this.UF = UF;
    }

    // Método utilizado para adicionar um instituto ao campus
    public void adicionarInstituto(Instituto instituto){
            campus.getListaInstituto().add(instituto);
    }

    // Método utilizado para adicionar um curso ao campus
    public void adicionarCurso(Curso curso){
            listaCursos.add(curso);
    }

    // Métodos para atualizar e obter atributos da classe (getters and setters)
    public String getNome() {
        return nome;
    }	
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getUF() {
        return UF;
    }
    public void setUF(String UF) {
        this.UF = UF;
    }	

    public ArrayList<Campus> getListaCampi() {
        return listaCampi;
    }
    public void setListaCampi(ArrayList<Campus> listaCampi) {
        this.listaCampi = listaCampi;
    }
    public ArrayList<Curso> getListaCursos() {
        return listaCursos;
    }
    public void setListaCursos(ArrayList<Curso> listaCursos) {
        this.listaCursos = listaCursos;
    }

    public void adicionarInstituto(Instituicao instituicao){

        System.out.println("Digite a sigla do instituto: ");  
        nome = c.nextLine();  
        System.out.println("Digite o nome do instituto: ");  
        cidade = c.nextLine();

    }

}
