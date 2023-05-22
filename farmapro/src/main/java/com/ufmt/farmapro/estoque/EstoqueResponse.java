package com.ufmt.farmapro.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EstoqueResponse {
    private int id;
    private int qtdAtual;
    private int qtdMin;


  public static EstoqueResponse from(Estoque entidade){
    EstoqueResponse response = new EstoqueResponse();
    response.setId(entidade.getId());
    response.setQtdAtual(entidade.getQtdAtual());
    response.setQtdMin(entidade.getQtdMin());
    return response;
  }
}
