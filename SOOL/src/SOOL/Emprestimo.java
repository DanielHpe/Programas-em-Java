/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SOOL;

import java.util .ArrayList;
import java.util.Date;

/**
 *
 * @author 18077
 */
public class Emprestimo {
    private Date dataEmp;
    private Date dateDev;
    private ArrayList<Aluno> listaAluno = new ArrayList<>();
    private ArrayList<Livro> listaLivro = new ArrayList<>();

    public Emprestimo(Date dataEmp, Date dateDev, Aluno aluno, Livro livro) {
        this.dataEmp = dataEmp;
        this.dateDev = dateDev;
        this.listaAluno.add(aluno);
        this.listaLivro.add(livro );
    }

    public ArrayList<Aluno> pesquisaLivroAluno(String titulo){
        ArrayList<Aluno> l = new ArrayList<>();
        return l;
    }
    
    public Date getDataEmp() {
        return dataEmp;
    }

    public void setDataEmp(Date dataEmp) {
        this.dataEmp = dataEmp;
    }

    public Date getDateDev() {
        return dateDev;
    }

    public void setDateDev(Date dateDev) {
        this.dateDev = dateDev;
    }
    
    

}
