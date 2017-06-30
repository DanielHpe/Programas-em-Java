/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoEmissora;

import java.util.ArrayList;
import java.util.Scanner;
import projetoemissora.ProjetoEmissora;


public class EmissoraArrayList {

    private int idSequencial;
    private String nome;
    private ArrayList<ReporterArrayList> ArrayReporteres;
    private ArrayList<ProgramaArrayList> ArrayProgramas;

    public EmissoraArrayList(int idSequencial, String nome) {
        this.idSequencial = idSequencial;
        this.nome = nome;
        this.ArrayReporteres = new ArrayList<>();
        this.ArrayProgramas = new ArrayList<>();
    }

    public void AssociarReporter(ArrayList<ReporterArrayList> R) {
            Scanner sc = new Scanner(System.in);
            if (R.isEmpty()) {
                ArrayReporteres = R;
                System.out.println("Reporter Associado com sucesso!");
                sc.nextLine();
            } else {
                System.out.println("Reporter já associado");
                sc.nextLine();
            }        
    }

    public void RemoverReporter(int idReporter) {
        Scanner sc = new Scanner(System.in);
        if (ArrayReporteres.size() > 0) {
            ArrayReporteres.remove(idReporter);
        } else {
            System.out.println("é Necessário ter pelo menos um Reporter associado a Empresa");
            sc.nextLine();
        }
    }

    public void InserirPrograma(ProgramaArrayList P) {
        ArrayProgramas.add(P);
    }

    public void RemoverPrograma(int idPrograma) {
        Scanner sc = new Scanner(System.in);
        if (VerificaProgramaCadastro(idPrograma, ArrayProgramas)) {
            ArrayProgramas.remove(idPrograma);
        } else {
            System.out.println("Id Inválido");
            sc.nextLine();
        }
    }

    public void ListadeProgramas() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ArrayProgramas.size(); i++) {
            System.out.println("Id: " + ArrayProgramas.get(i).getIdSequencial());
            System.out.println("Nome: " + ArrayProgramas.get(i).getNome());
        }
        sc.nextLine();
    }

    public void ListadeProgramasporReporter(int idReporter) {
    }

    public void ListadeReporteres() {
         Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ArrayReporteres.size(); i++) {
            System.out.println("Id: " + ArrayReporteres.get(i).getIdSequecial());
            System.out.println("Nome: " + ArrayReporteres.get(i).getNome());
        }
        sc.nextLine();
    }

    public int getIdSequencial() {
        return idSequencial;
    }

    public void setIdSequencial(int idSequencial) {
        this.idSequencial = idSequencial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<ReporterArrayList> getReporteres() {
        return ArrayReporteres;
    }

    public void addReporteres(ReporterArrayList R) {
        this.ArrayReporteres.add(R);
    }

    public ArrayList<ProgramaArrayList> getArrayProgramas() {
        return ArrayProgramas;
    }


    public void addProgramas(ProgramaArrayList P) {
        this.ArrayProgramas.add(P);    
    }

    public boolean VerificaReporterCadastro(int id, ArrayList<ReporterArrayList> ArrayR) {
        // Verifica se o reporter está previamento cadastrado para poder associ-lo
        return id == ArrayR.get(id).getIdSequecial();
    }

    public boolean VerificaProgramaCadastro(int id, ArrayList<ProgramaArrayList> ArrayP) {
        // Verifica se o reporter está previamento cadastrado para poder associa-lo

        return id == ArrayP.get(id).getIdSequencial();
    }

}
