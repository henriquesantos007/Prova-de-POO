package sistema_de_pagamentos_de_funcionario.entities;

public class Comissionado extends Funcionario{
    private Double percentual_comicao;
    private Double total_de_vendas;

    public Comissionado(String nome, String id, Double percentual_comicao, Double total_de_vendas){
        super(nome, id);
        this.percentual_comicao = percentual_comicao;
        this.total_de_vendas = total_de_vendas;
    }

    public Double getPercentual_comicao() {
        return percentual_comicao;
    }

    public Double getTotal_de_vendas() {
        return total_de_vendas;
    }

    public void setPercentual_comicao(Double percentual_comicao) {
        this.percentual_comicao = percentual_comicao;
    }

    public void setTotal_de_vendas(Double total_de_vendas) {
        this.total_de_vendas = total_de_vendas;
    }

    public Double salario(){
        return total_de_vendas * percentual_comicao/100;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("\nTipo de funcionário: Comisionado");
        sb.append("\nNome: " + nome);
        sb.append("\nId: " + id);
        sb.append("\nPercentual de Comissão: " + Math.round(percentual_comicao) + "%");
        sb.append("\nTotal de vendas: R$" + String.format("%.2f",total_de_vendas));
        sb.append("\nSalário final: R$" + String.format("%.2f", salario()));

        return sb.toString();
    }
}
