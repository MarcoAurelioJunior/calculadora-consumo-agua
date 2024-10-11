
package com.mycompany.upxii.calculadora_consumo_agua.Classes;

public class Empresa {
    private String nome;
    private double tarifaFixa;
    private double faixa1Tarifa;
    private double faixa2Tarifa;
    private double faixa3Tarifa;
    private String dataUltimaAtualizacao;

    public Empresa(String nome, double tarifaFixa, double faixa1Tarifa, double faixa2Tarifa, double faixa3Tarifa, String dataUltimaAtualizacao) {
        this.nome = nome;
        this.tarifaFixa = tarifaFixa;
        this.faixa1Tarifa = faixa1Tarifa;
        this.faixa2Tarifa = faixa2Tarifa;
        this.faixa3Tarifa = faixa3Tarifa;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTarifaFixa() {
        return tarifaFixa;
    }

    public void setTarifaFixa(double tarifaFixa) {
        this.tarifaFixa = tarifaFixa;
    }

    public double getFaixa1Tarifa() {
        return faixa1Tarifa;
    }

    public void setFaixa1Tarifa(double faixa1Tarifa) {
        this.faixa1Tarifa = faixa1Tarifa;
    }

    public double getFaixa2Tarifa() {
        return faixa2Tarifa;
    }

    public void setFaixa2Tarifa(double faixa2Tarifa) {
        this.faixa2Tarifa = faixa2Tarifa;
    }

    public double getFaixa3Tarifa() {
        return faixa3Tarifa;
    }

    public void setFaixa3Tarifa(double faixa3Tarifa) {
        this.faixa3Tarifa = faixa3Tarifa;
    }

    public String getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
