/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author danih
 */
public class Ciclo implements Serializable{
    
    private String descTema;
    private ArrayList<Modulo> listaModulos = new ArrayList <> ();
    private Modulo m;
    public static ArrayList<Ciclo> listCiclos = new ArrayList<>();
    public Curso curso;
    
    public Ciclo (Curso c, String descTema){
        this.descTema = descTema;
        this.curso = c;
        listCiclos.add(this);
    }
    
    public String getDescTema() {
        return descTema;
    }

    public Curso getCurso() {
        return curso;
    }
    
    public static void excluirCiclos(Curso c, boolean isGrad){
        for(int i = 0; i < listCiclos.size(); i++){
            if(listCiclos.get(i).getCurso().getCodigo().equalsIgnoreCase(c.getCodigo())){
                listCiclos.remove(i);
            }
        }
    }

    public void setDescTema(String descTema) {
        this.descTema = descTema;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public void retornaModulo(){
        int i = 0;
        Iterator<Modulo> iterator = listaModulos.iterator();
        while (iterator.hasNext()) {
            i++;
        }
    }
    
    public void removeModulo(int codigo){
		listaModulos.remove(codigo);
    }    
}
