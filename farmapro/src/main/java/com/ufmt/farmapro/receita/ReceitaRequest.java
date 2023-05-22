package com.ufmt.farmapro.receita;

import java.util.Date;

public class ReceitaRequest {
    private Date data;
    private String descricao;
    private boolean receitaValida;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    public boolean isReceitaValida() {
        return receitaValida;
    }
    public void setReceitaValida(boolean receitaValida) {
        this.receitaValida = receitaValida;
    }

    
}
