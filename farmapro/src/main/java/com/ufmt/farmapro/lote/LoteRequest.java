package com.ufmt.farmapro.lote;

import java.util.Date;

public class LoteRequest {
    private Date data;
    private boolean proxVenc;
    private int produtoId;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public boolean getProxVenc() {
        return proxVenc;
    }
    public void setProxVenc(boolean proxVenc) {
        this.proxVenc = proxVenc;
    }

    public int getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }
    
}
