package sistema_de_pagamentos_de_funcionario.entities;

public class Horista extends Funcionario {
    private int horasTrabalhadas;
    private Double valorPorHora;

    public Horista(String nome, String id, int horasTrabalhadas, Double valorPorHora){
        super(nome,id);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    public Double getValorPorHora() {
        return valorPorHora;
    }
    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Double salario(){
        return horasTrabalhadas * valorPorHora;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nTipo de Funcionário: Horista");
        sb.append("\nNome: " + nome);
        sb.append("\nId: " + id);
        sb.append("\nHoras Trabalhadas: " + horasTrabalhadas + " horas");
        sb.append("\nValor por hora: R$" + String.format("%.2f",valorPorHora));
        sb.append("\nSalário final: R$" + String.format("%.2f", salario()));

        return sb.toString();
    }
}
