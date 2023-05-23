package com.ufmt.farmapro.item;

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
@RequestMapping(path = "/item")
@RequiredArgsConstructor
public class ItemController {
  
  private final ItemRepository repository;

  @GetMapping(path = "/")
  public List<Item> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ItemResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Item> found = repository.findById(id);
    if(found.isPresent()){
    ItemResponse response = ItemResponse.from(found.get());
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
  public ResponseEntity<Object> cadastrar(@RequestBody ItemRequest request){ 
    Item item = new Item();
    item.setQtd(request.getQtd());
    item.setSubtotal(request.getSubtotal());

   


    try {
      repository.save(item);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody ItemRequest request){
    Item item = new Item();
    item.setId(id);
    item.setQtd(request.getQtd());
    item.setSubtotal(request.getSubtotal());

    try {
      repository.save(item);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}


