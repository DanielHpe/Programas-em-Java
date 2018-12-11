/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sool;

/**
 *
 * @author danih
 */
class Professor {
    
    private String nome;
    private String titulacao;
    private String CPF;

    // Constructor
    public Professor(String nome, String titulacao, String cpf) {
            this.nome = nome;
            this.titulacao = titulacao;
            this.CPF = cpf;
    }

    // Getters e Setters
    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getTitulacao() {
            return titulacao;
    }

    public void setTitulacao(String titulacao) {
            this.titulacao = titulacao;
    }

    public String getCPF() {
            return CPF;
    }

    public void setCPF(String cpf) {
            CPF = cpf;
    }    
}
