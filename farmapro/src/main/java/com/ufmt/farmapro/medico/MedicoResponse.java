package com.ufmt.farmapro.medico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MedicoResponse {
    private int id;
    private String nome;
    private int crm;


  public static MedicoResponse from(Medico entidade){
    MedicoResponse response = new MedicoResponse();
    response.setId(entidade.getId());
    response.setNome(entidade.getNome());
    response.setCrm(entidade.getCrm());
    return response;
  }
}
