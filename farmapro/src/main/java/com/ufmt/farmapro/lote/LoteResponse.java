package com.ufmt.farmapro.lote;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoteResponse {
    private int id;
    private Date data;
    private boolean proxVenc;


  public static LoteResponse from(Lote entidade){
    LoteResponse response = new LoteResponse();
    response.setId(entidade.getId());
    response.setData(entidade.getData());
    response.setProxVenc(entidade.isProxVenc());
    return response;
  }
}
