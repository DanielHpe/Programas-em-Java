/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestaoEmissora;


public class ReporterArrayList {

    private int idSequecial;
    private String nome;

    public ReporterArrayList() {
        this.idSequecial = 0;
        this.nome = null;
    }

    public int getIdSequecial() {
        return idSequecial;
    }

    public void setIdSequecial(int idSequecial) {
        this.idSequecial = idSequecial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
