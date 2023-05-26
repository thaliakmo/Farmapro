package com.ufmt.farmapro.estoque;

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
@RequestMapping(path = "/estoque")
@RequiredArgsConstructor
public class EstoqueController {
  
  private final EstoqueRepository repository;

  @GetMapping(path = "/")
  public List<Estoque> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<EstoqueResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Estoque> found = repository.findById(id);
    if(found.isPresent()){
      EstoqueResponse response = EstoqueResponse.from(found.get());
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

  @PostMapping(path = "/cadastrar")
  public ResponseEntity<Object> cadastrar(@RequestBody EstoqueRequest request){
    Estoque estoque = new Estoque();
    estoque.setQtdAtual(request.getQtdAtual());
    estoque.setQtdMin(request.getQtdMin());

    try {
      repository.save(estoque);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody EstoqueRequest request){
    Estoque estoque = new Estoque();
    estoque.setId(id);
    estoque.setQtdAtual(request.getQtdAtual());
    estoque.setQtdMin(request.getQtdMin());

    try {
      repository.save(estoque);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
