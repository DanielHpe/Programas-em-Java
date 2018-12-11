/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;
import static sool.Ciclo.listCiclos;
import static sool.Graduacao.listaGraduacoes;

/**
 *
 * @author danih
 */
public class Extensao extends Curso implements Serializable{
    
    private int cargaHoraria;
    private ArrayList <Turma> listaExtensaoCiclo = new ArrayList<>();
    public static ArrayList<Extensao> listaExtensao = new ArrayList<>();
    
    // Constructor
    public Extensao(String codigo, String nome, String turno, int cargaHoraria) {
        super(codigo, nome, turno);
        this.cargaHoraria = cargaHoraria;
        listaExtensao.add(this);
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public ArrayList<Turma> getListaExtensaoCiclo() {
        return listaExtensaoCiclo;
    }

    public void setListaExtensaoCiclo(ArrayList<Turma> listaExtensaoCiclo) {
        this.listaExtensaoCiclo = listaExtensaoCiclo;
    }
    
    public static void updateLista(Extensao e, String nome, String turno, int cargaHoraria){
        e.setNome(nome);
        e.setTurno(turno);
        e.setCargaHoraria(cargaHoraria);
    }
    
    public static void excluirExtensao(Extensao extensao){
        listaExtensao.remove(extensao);
    }
    
}
