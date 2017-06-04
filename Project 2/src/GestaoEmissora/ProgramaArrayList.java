/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoEmissora;

import java.util.ArrayList;


public class ProgramaArrayList {

    private int idSequencial;
    private String nome;
    private ArrayList<ReporterArrayList> Reporteres;

    public ProgramaArrayList() {
        this.idSequencial = 0;
        this.nome = null;
        this.Reporteres = new ArrayList<>();
    }

    public void adicionarReporter(ReporterArrayList R) {
        Reporteres.add(R);
    }

    public void removerReporter(int idReporter) {
        for (int i = 0; i < Reporteres.size(); i++) {
            if (Reporteres.get(i).getIdSequecial() == idReporter) {
                Reporteres.remove(i);
            }
        }
    }

    public void getReporteres() {
        for (int x = 0; x < Reporteres.size(); x++) {
            if (Reporteres.get(x) != null) {
                System.out.println("Id: " + Reporteres.get(x).getIdSequecial() + " Nome" + Reporteres.get(x).getNome());
            }
        }
    }

    public void getReporter(int idReporter) {
        for (int i = 0; i < Reporteres.size(); i++) {
            if (Reporteres.get(i).getIdSequecial() == idReporter) {
                System.out.println("Id: " + Reporteres.get(i).getIdSequecial() + " Nome" + Reporteres.get(i).getNome());
            } else {
                System.out.println("Não existe Reporter com este ID.");
            }
        }
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

    public void setReporteres(ArrayList<ReporterArrayList> Reporteres) {
        this.Reporteres = Reporteres;
    }
}

