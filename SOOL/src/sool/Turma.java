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
public class Turma implements Serializable{
    
    private int codSequencia;
    protected ArrayList<Aluno> listaAlunos = new ArrayList<>();
    
    public Turma(int codsequencia){
        this.codSequencia = codsequencia;
    }

    public int getCodSequencia() {
        return codSequencia;
    }

    public void setCodSequencia(int codSequencia) {
        this.codSequencia = codSequencia;
    }
    
    public void removeAluno(String matricula){
        listaAlunos.remove(matricula);
    }
     
    public ArrayList<Aluno> listaAluno(){
        return listaAlunos;
    }
    
    public String AlterarCodigo(String NovoCodigo, String getcodigoSequencia){
        getcodigoSequencia = NovoCodigo;
        return NovoCodigo;
    }
    
}
