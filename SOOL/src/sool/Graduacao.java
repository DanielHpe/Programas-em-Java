/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author danih
 */
public class Graduacao extends Curso implements Serializable{
    
    private ArrayList<Ciclo> listaCiclo = new ArrayList<>();
    public static ArrayList<Graduacao> listaGraduacoes = new ArrayList<>();
    
    //Constructor
    public Graduacao(String codigo, String nome, String turno) {
        super(codigo, nome, turno);
        listaGraduacoes.add(this);
    }
    
    public static void excluirGraduacao(Graduacao graduacao){
        listaGraduacoes.remove(graduacao);
    }
    
    public static void updateInfos(Graduacao g, String nome, String turno){ 
        g.setNome(nome);
        g.setTurno(turno); 
    }

}
