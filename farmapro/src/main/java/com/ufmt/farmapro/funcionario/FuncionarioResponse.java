package com.ufmt.farmapro.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FuncionarioResponse {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;


  public static FuncionarioResponse from(Funcionario entidade){
    FuncionarioResponse response = new FuncionarioResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setEmail(entidade.getEmail());
    response.setEndereco(entidade.getEndereco());
    response.setTelefone(entidade.getTelefone());
    return response;
  }
}

