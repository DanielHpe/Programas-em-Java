/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoEmissora;

import java.util.ArrayList;
import java.util.Scanner;
import projetoemissora.ProjetoEmissora;


public class Emissora {

    private int idSequencial;
    private String nome;
    private Reporter Reporteres[];
    private Programa Programas[];
    private ArrayList<Reporter> ArrayReporteres;
    private ArrayList<Reporter> ArrayProgramas;
    private int posR, posP;

    public Emissora(int idSequencial, String nome) {
        this.idSequencial = idSequencial;
        this.nome = nome;
        this.posR = 0;
        this.posP = 0;
        this.Reporteres = new Reporter[100];
        this.Programas = new Programa[100];
        this.ArrayReporteres = new ArrayList<>();
        this.ArrayProgramas = new ArrayList<>();
    }

    public void AssociarReporter(Reporter R) {
        if (Reporteres.length > 0) {
            Scanner sc = new Scanner(System.in);
            if (Reporteres[R.getIdSequecial()] == null) {
                Reporteres[R.getIdSequecial()] = R;
                posR++;
                System.out.println("Reporter Associado com sucesso!");
                sc.nextLine();
            } else {
                System.out.println("Reporter já associado");
                sc.nextLine();
            }
        }
    }

    public void RemoverReporter(int idReporter) {
        Scanner sc = new Scanner(System.in);
        if (posR > 0) {
            Reporteres[idReporter] = null;
        } else {
            System.out.println("é Necessário ter pelo menos um Reporter associado a Empresa");
            sc.nextLine();
        }
    }

    public void InserirPrograma(Programa P) {
        Programas[posP] = P;
        posP++;
    }

    public void RemoverPrograma(int idPrograma) {
        Scanner sc = new Scanner(System.in);
        if (VerificaProgramaCadastro(idPrograma, Programas)) {
            Programas[idPrograma] = null;
        } else {
            System.out.println("Id Inválido");
            sc.nextLine();
        }
    }

    public void ListadeProgramas() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Programas.length; i++) {
            if (Programas[i] != null) {
                System.out.println("Id: " + Programas[i].getIdSequencial());
                System.out.println("Nome: " + Programas[i].getNome());
            }
        }
    }

    public void ListadeProgramasporReporter(int idReporter) {

    }

    public void ListadeReporteres() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Reporteres.length; i++) {
            if (Reporteres[i] != null) {
                System.out.println("Id: " + Reporteres[i].getIdSequecial());
                System.out.println("Nome: " + Reporteres[i].getNome());
            }
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

    public Reporter[] getReporteres() {
        return Reporteres;
    }

    public void addReporteres(Reporter R) {
        this.Reporteres[posR] = R;
        posR++;
    }

    public Programa[] getProgramas() {
        return Programas;
    }

    public void addProgramas(Programa P) {
        this.Programas[posP] = P;
        posP++;
    }

    public boolean VerificaReporterCadastro(int id, Reporter ListaR[]) {
        // Verifica se o reporter está previamento cadastrado para poder associ-lo
        for (int y = 0; y < ListaR.length; y++) {
            if (id == ListaR[y].getIdSequecial()) {
                return true;
            }
        }
        return false;
    }

    public boolean VerificaProgramaCadastro(int id, Programa ListaP[]) {
        // Verifica se o reporter está previamento cadastrado para poder associ-lo
        for (int y = 0; y < ListaP.length; y++) {
            if (id == ListaP[y].getIdSequencial()) {
                return true;
            }
        }
        return false;
    }

}
