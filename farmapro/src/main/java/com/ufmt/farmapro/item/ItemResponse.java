package com.ufmt.farmapro.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemResponse {
    private int id;
    private int qtd;
    private double subtotal;


  public static ItemResponse from(Item entidade){
    ItemResponse response = new ItemResponse();
    response.setId(entidade.getId());
    response.setQtd(entidade.getQtd());
    response.setSubtotal(entidade.getSubtotal());
    return response;
  }
}
