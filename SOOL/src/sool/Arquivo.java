/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danih
 */
public class Arquivo {
    
    public static FileOutputStream fout;
    public static FileInputStream fin;
    
    public ObjectInputStream ois;
    public static ObjectOutputStream oos;
     
    private ArrayList<Graduacao> listGrads = new ArrayList<>();
    private ArrayList<Extensao> listExten = new ArrayList<>();
    private ArrayList<Ciclo> listPeriodos = new ArrayList<>();
    private ArrayList<Disciplina> listDisciplinas = new ArrayList<>();
    private ArrayList<TurmaGraduacao> listTurmasGrad = new ArrayList<>();
    private ArrayList<TurmaExtensao> listaTurmaExtensoes = new ArrayList<>();
    private ArrayList<Aluno> listaAlunos = new ArrayList<>();
    
    public void saveGraduacao(String dados, ArrayList<Graduacao> lista) 
            throws FileNotFoundException, IOException {
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();
    }
    
    public ArrayList<Graduacao> readGraduacao(String dados){
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listGrads = (ArrayList<Graduacao>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listGrads.clear();
        }
        
        return listGrads;
    } 
    
    public void saveExtensao(String dados, ArrayList<Extensao> lista) 
            throws FileNotFoundException, IOException {
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();
    }
    
    public ArrayList<Extensao> readExtensao(String dados) {
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listExten = (ArrayList<Extensao>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listExten.clear();
        }
        
        return listExten;
    } 
    
    public void savePeriodo(String dados, ArrayList<Ciclo> lista) throws Exception{
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();
    }

    public ArrayList<Ciclo> readPeriodo(String dados){
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listPeriodos = (ArrayList<Ciclo>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listPeriodos.clear();
        }
        
        return listPeriodos;
    }
    
    public void saveDisciplina(String dados, ArrayList<Disciplina> lista) throws Exception{
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();    
    }
    
    public ArrayList<Disciplina> readDisciplinas(String dados){
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listDisciplinas = (ArrayList<Disciplina>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listDisciplinas.clear();
        }
        
        return listDisciplinas;
    }
    
    public void saveTurmaGrad(String dados, ArrayList<TurmaGraduacao> lista) throws Exception{
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();
    }
    
    public ArrayList<TurmaGraduacao> readTurmaGrad(String dados){
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listTurmasGrad = (ArrayList<TurmaGraduacao>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listTurmasGrad.clear();
        }
        
        return listTurmasGrad;
    }
    
    public void saveTurmaExtensao(String dados, ArrayList<TurmaExtensao> lista) throws Exception{
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();  
    }
    
    public ArrayList<TurmaExtensao> readTurmaExtensao(String dados){
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listaTurmaExtensoes = (ArrayList<TurmaExtensao>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listaTurmaExtensoes.clear();
        }
        
        return listaTurmaExtensoes;
    }
    
    public void saveAluno(String dados, ArrayList<Aluno> lista) throws Exception{
        fout = new FileOutputStream (dados);
        oos = new ObjectOutputStream(fout);
        oos.writeObject(lista);
        fout.close();  
    }
    
    public ArrayList<Aluno> readAluno(String dados){
        
        try {
            fin = new FileInputStream (dados);
            ObjectInputStream ois = new ObjectInputStream(fin);
            listaAlunos = (ArrayList<Aluno>) ois.readObject();
            fin.close();
        } catch (Exception ex) {
            listaAlunos.clear();
        }
        
        return listaAlunos;
    }
    
}
