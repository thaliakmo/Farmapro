package com.ufmt.farmapro.medico;

import java.util.List;
import java.util.Optional;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/medico")
@RequiredArgsConstructor
public class MedicoController {
  
  private final MedicoRepository repository;

  @GetMapping(path = "/")
  public List<Medico> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<MedicoResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Medico> found = repository.findById(id);
    if(found.isPresent()){
        MedicoResponse response = MedicoResponse.from(found.get());
      return ResponseEntity.ok().body(response);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping(path = "/{pk}")
  public ResponseEntity<Void> remover(@PathVariable(name = "pk") int id){
    try {
      repository.deleteById(id);
      return ResponseEntity.ok().build();
    } catch(EmptyResultDataAccessException erro){
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<Object> cadastrar(@RequestBody MedicoRequest request){
    Medico medico = new Medico();
    medico.setNome(request.getNome());
    medico.setCrm(request.getCrm());

    try {
      repository.save(medico);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody MedicoRequest request){
    Medico medico = new Medico();
    medico.setId(id);
    medico.setNome(request.getNome());
    medico.setCrm(request.getCrm());

    try {
      repository.save(medico);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}


