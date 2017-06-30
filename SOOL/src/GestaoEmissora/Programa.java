/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoEmissora;


public class Programa {

    private int idSequencial;
    private String nome;
    private Reporter Reporteres[];
    private int posR;

    public Programa() {
        this.idSequencial = 0;
        this.nome = null;
        this.Reporteres = new Reporter[posR];
        this.posR = 0;
    }

    public void adicionarReporter(Reporter R) {
        Reporteres[posR] = R;
        this.posR++;
    }

    public void removerReporter(int idReporter) {
        for (int i = 0; i < Reporteres.length; i++) {
            if (Reporteres[i].getIdSequecial() == idReporter) {
                Reporteres[i] = null;
            }
        }
    }

    public void getReporteres() {
        for (int x = 0; x < Reporteres.length; x++) {
            if (Reporteres[x] != null) {
                System.out.println("Id: " + Reporteres[x].getIdSequecial() + " Nome" + Reporteres[x].getNome());
            }
        }
    }

    public void getReporter(int idReporter) {
        for (int i = 0; i < Reporteres.length; i++) {
            if (Reporteres[i].getIdSequecial() == idReporter) {
                System.out.println("Id: " + Reporteres[i].getIdSequecial() + " Nome" + Reporteres[i].getNome());
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

    public void setReporteres(Reporter[] Reporteres) {
        this.Reporteres = Reporteres;
    }
}
