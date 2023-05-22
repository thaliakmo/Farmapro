package com.ufmt.farmapro.estoque;

public class EstoqueRequest {
    private int qtdAtual;
    private int qtdMin;

    public int getQtdAtual() {
        return qtdAtual;
    }
    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdMin() {
        return qtdMin;
    }
    public void setQtdMin(int qtdMin) {
        this.qtdMin = qtdMin;
    }
    
}
