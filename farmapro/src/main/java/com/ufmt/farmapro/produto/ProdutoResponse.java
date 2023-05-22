package com.ufmt.farmapro.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoResponse {
    private int id;
    private String nome;
    private String descricao;
    private double valor;


  public static ProdutoResponse from(Produto entidade){
    ProdutoResponse response = new ProdutoResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setDescricao(entidade.getDescricao());
    response.setValor(entidade.getValor());
    return response;
  }
}

