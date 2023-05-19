package com.ufmt.farmapro.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClienteResponse {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String telefone;

  public static ClienteResponse from(Cliente entidade){
    ClienteResponse response = new ClienteResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setEmail(entidade.getEmail());
    response.setEndereco(entidade.getEndereco());
    response.setTelefone(entidade.getTelefone());
    return response;
  }
}