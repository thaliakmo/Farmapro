package com.ufmt.farmapro.receita;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReceitaResponse {
    private int id;
    private Date data;
    private String descricao;
    private boolean receitaValida;


  public static ReceitaResponse from(Receita entidade){
    ReceitaResponse response = new ReceitaResponse();
    response.setId(entidade.getId());
    response.setData(entidade.getData());
    response.setDescricao(entidade.getDescricao());
    response.setReceitaValida(entidade.isReceitaValida());
    return response;
  }
}

