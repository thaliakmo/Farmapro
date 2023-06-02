package com.ufmt.farmapro.lote;

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

import com.ufmt.farmapro.produto.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/lote")
@RequiredArgsConstructor
public class LoteController {
  
  private final LoteRepository repository;
  private final ProdutoRepository produtoRepository;

  @GetMapping(path = "/")
  public List<Lote> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<LoteResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Lote> found = repository.findById(id);
    if(found.isPresent()){
        LoteResponse response = LoteResponse.from(found.get());
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
  public ResponseEntity<Object> cadastrar(@RequestBody LoteRequest request){ 
    Lote lote = new Lote();
    lote.setData(request.getData());
    lote.setProxVenc(request.getProxVenc());
    lote.setProduto(produtoRepository.getReferenceById(request.getProdutoId()));

    try {
      repository.save(lote);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody LoteRequest request){
    Lote lote = new Lote();
    lote.setId(id);
    lote.setData(request.getData());
    lote.setProxVenc(request.getProxVenc());
    lote.setProduto(produtoRepository.getReferenceById(request.getProdutoId()));

    try {
      repository.save(lote);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}


