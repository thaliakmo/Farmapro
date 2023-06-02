package com.ufmt.farmapro.estoque;

public class EstoqueRequest {
    private int qtdAtual;
    private int qtdMin;
    private int loteId;

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
    
    public int getLoteId() {
        return loteId;
    }
    public void setLoteId(int loteId) {
        this.loteId = loteId;
    }
    
    
}
