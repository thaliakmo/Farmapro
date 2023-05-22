package com.ufmt.farmapro.lote;

import java.util.Date;

public class LoteRequest {
    private Date data;
    private boolean proxVenc;

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public boolean isProxVenc() {
        return proxVenc;
    }
    public void setProxVenc(boolean proxVenc) {
        this.proxVenc = proxVenc;
    }
    
}
