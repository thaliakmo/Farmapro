package com.ufmt.farmapro.fornecedor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FornecedorResponse {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;


  public static FornecedorResponse from(Fornecedor entidade){
    FornecedorResponse response = new FornecedorResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setEmail(entidade.getEmail());
    response.setEndereco(entidade.getEndereco());
    response.setTelefone(entidade.getTelefone());
    return response;
  }
}

