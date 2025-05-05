package sistema_de_pagamentos_de_funcionario.entities;

public class Assalariado extends Funcionario {
    private Double salario_fixo;

    public Assalariado(String nome, String id, Double salario_fixo){
        super(nome, id);
        this.salario_fixo = salario_fixo;
    }

    public Double getSalario_fixo() {
        return salario_fixo;
    }

    public void setSalario_fixo(Double salario_fixo) {
        this.salario_fixo = salario_fixo;
    }

    public Double salario(){
        return salario_fixo;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nTipo de funcionário: Comisionado");
        sb.append("\nNome: " + nome);
        sb.append("\nId: " + id);
        sb.append("\nSalário fixo: R$" + String.format("%.2f",salario_fixo));
        sb.append("\nSalário final: R$" + String.format("%.2f", salario()));

        return sb.toString();
    }
}
