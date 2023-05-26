package com.ufmt.farmapro.produto;

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
@RequestMapping(path = "/produto")
@RequiredArgsConstructor
public class ProdutoController {
  
  private final ProdutoRepository repository;

  @GetMapping(path = "/")
  public List<Produto> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ProdutoResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Produto> found = repository.findById(id);
    if(found.isPresent()){
        ProdutoResponse response = ProdutoResponse.from(found.get());
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
  public ResponseEntity<Object> cadastrar(@RequestBody ProdutoRequest request){
    Produto produto = new Produto();
    produto.setNome(request.getNome());
    produto.setDescricao(request.getDescricao());
    produto.setValor(request.getValor());

    try {
      repository.save(produto);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody ProdutoRequest request){
    Produto produto = new Produto();
    produto.setId(id);
    produto.setNome(request.getNome());
    produto.setDescricao(request.getDescricao());
    produto.setValor(request.getValor());

    try {
      repository.save(produto);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
