package com.ufmt.farmapro.pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PedidoResponse {
    private int id;
    private double total;


  public static PedidoResponse from(Pedido entidade){
    PedidoResponse response = new PedidoResponse();
    response.setId(entidade.getId());
    response.setTotal(entidade.getTotal());
    return response;
  }
}

