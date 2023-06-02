package com.ufmt.farmapro.receita;

import java.util.Date;

public class ReceitaRequest {
    private Date data;
    private String descricao;
    private boolean receitaValida;
    private int clienteId;
    private int medicoId;
    private int pedidoId;

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
    public boolean getReceitaValida() {
        return receitaValida;
    }
    public void setReceitaValida(boolean receitaValida) {
        this.receitaValida = receitaValida;
    }
    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public int getMedicoId() {
        return medicoId;
    }
    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }
    public int getPedidoId() {
        return pedidoId;
    }
    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }
    
}
