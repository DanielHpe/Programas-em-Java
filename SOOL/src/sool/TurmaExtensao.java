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
public class TurmaExtensao extends Turma implements Serializable{
    
    private String dataInicio;
    private String dataFim;
    private ArrayList <Extensao> listaExtensaoCiclo = new ArrayList <Extensao>();
    
    public static ArrayList<TurmaExtensao> turmaExtensoes = new ArrayList<>();
    
    private Ciclo cl;
    private Curso c;
    private Disciplina d;

    //Construtor
    public TurmaExtensao(int codSequencia, String dataInicio, String dataFim,
            Ciclo cl, Curso c, Disciplina d) {
        super(codSequencia);
        this.cl = cl;
        this.c = c;
        this.d = d;
        this.dataFim = dataFim;
        this.dataInicio = dataInicio;
        turmaExtensoes.add(this);
    }

    public Ciclo getCl() {
        return cl;
    }

    public Curso getC() {
        return c;
    }

    public Disciplina getD() {
        return d;
    }
    
    public String IdentificarAluno(String nome, String endereco){
        for(int i = 0; i < getListaAlunos().size(); i++){
            if(nome.equalsIgnoreCase(getListaAlunos().get(i).getNome())){
                return this.getListaAlunos().get(i).getMatricula();
            } else{
                return null;
            }
        }
        return null;
    }  
    
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public ArrayList<Extensao> getListaExtensaoCiclo() {
        return listaExtensaoCiclo;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    
    public static void removeTurma(Ciclo cl, Curso c, Disciplina d){
        for(TurmaExtensao tg : turmaExtensoes){
            if(tg.getCl().equals(cl) && tg.getCl().getCurso().equals(c)
                        && tg.getD().equals(d)){
                turmaExtensoes.remove(tg);
                Aluno.removeAlunos(cl, c, d, tg);
                System.out.println("Turma removida");
                break;
            }
        }
    }
    
    
}
