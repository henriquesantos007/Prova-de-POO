package sistema_de_pagamentos_de_funcionario.entities;

public abstract class Funcionario {
    protected String nome;
    protected String id;
    

    public Funcionario(String nome, String id){
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public abstract Double salario();

    public abstract String toString();
}