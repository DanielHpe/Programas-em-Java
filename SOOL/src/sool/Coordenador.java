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
class Coordenador extends Professor{
    
    private int cargaHoraria;
    private Emprestimo bonus;
    private ArrayList<Instituto> listaInstitutos = new ArrayList<>();
    private ArrayList<Curso> listaCursos = new ArrayList<>();

    public Coordenador(String nome, String titulacao, String CPF, int cargaHoraria, Emprestimo bonus) {
            super(nome, titulacao, CPF);
            this.cargaHoraria = cargaHoraria;
            this.bonus = bonus;
            this.listaInstitutos = new ArrayList<Instituto>();
            this.listaCursos = new ArrayList<Curso>();
    }
    // Getter and Setter //
    public int getCargaHoraria() {
            return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
            this.cargaHoraria = cargaHoraria;
    }
    public Emprestimo getBonus() {
            return bonus;
    }
    public void setBonus(Emprestimo bonus) {
            this.bonus = bonus;
    }

    // Adicionar um novo instituto //
    public void addInstituto(Instituto instituto) {
            this.listaInstitutos.add(instituto);
    }
    // Retorna uma lista de curso do turno da noite, vinculadas a esse coordenador //
    public ArrayList<Curso> listarCursosNoite(){
            ArrayList<Curso> cursosNoite = new ArrayList<Curso>();
            for(Curso p: listaCursos) {
                    if(p.getTurno().equalsIgnoreCase("noite")) {
                            cursosNoite.add(p);
                    }
            }
            return cursosNoite;
    }    
}
