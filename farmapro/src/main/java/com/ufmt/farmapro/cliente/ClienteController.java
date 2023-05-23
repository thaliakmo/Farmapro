package com.ufmt.farmapro.cliente;

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
@RequestMapping(path = "/cliente")
@RequiredArgsConstructor
public class ClienteController {
  
  private final ClienteRepository repository;

  @GetMapping(path = "/")
  public List<Cliente> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ClienteResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Cliente> found = repository.findById(id);
    if(found.isPresent()){
      ClienteResponse response = ClienteResponse.from(found.get());
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
  public ResponseEntity<Object> cadastrar(@RequestBody ClienteRequest request){
    Cliente cliente = new Cliente();
    cliente.setNome(request.getNome());
    cliente.setEmail(request.getEmail());
    cliente.setEndereco(request.getEndereco());
    cliente.setTelefone(request.getTelefone());

    try {
      repository.save(cliente);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody ClienteRequest request){
    Cliente cliente = new Cliente();
    cliente.setId(id);
    cliente.setNome(request.getNome());
    cliente.setEmail(request.getEmail());
    cliente.setEndereco(request.getEndereco());
    cliente.setTelefone(request.getTelefone());

    try {
      repository.save(cliente);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}