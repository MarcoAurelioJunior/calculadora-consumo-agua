
package com.mycompany.upxii.calculadora_consumo_agua.Classes;

public class Consumo {
    private double quantidade_litros;
    private String descricao;

    public Consumo(double quantidade_litros, String descricao) {
        this.quantidade_litros = quantidade_litros;
        this.descricao = descricao;
    }

    public double getQuantidade_litros() {
        return quantidade_litros;
    }

    public void setQuantidade_litros(double quantidade_litros) {
        this.quantidade_litros = quantidade_litros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
