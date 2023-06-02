package com.ufmt.farmapro.receita;

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

import com.ufmt.farmapro.cliente.ClienteRepository;
import com.ufmt.farmapro.medico.MedicoRepository;
import com.ufmt.farmapro.pedido.PedidoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/receita")
@RequiredArgsConstructor
public class ReceitaController {
  
  private final ReceitaRepository repository;
  private final ClienteRepository clienteRepository;
  private final MedicoRepository medicoRepository;
  private final PedidoRepository pedidoRepository;

  @GetMapping(path = "/")
  public List<Receita> index(){
    return repository.findAll();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<ReceitaResponse> getById(@PathVariable(name = "id") int id) {
    Optional<Receita> found = repository.findById(id);
    if(found.isPresent()){
        ReceitaResponse response = ReceitaResponse.from(found.get());
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
  public ResponseEntity<Object> cadastrar(@RequestBody ReceitaRequest request){
    Receita receita = new Receita();
    receita.setDescricao(request.getDescricao());
    receita.setData(request.getData());
    receita.setReceitaValida(request.getReceitaValida());
    receita.setCliente(clienteRepository.getReferenceById(request.getClienteId()));
    receita.setMedico(medicoRepository.getReferenceById(request.getMedicoId()));
    receita.setPedido(pedidoRepository.getReferenceById(request.getPedidoId()));


    try {
      repository.save(receita);
    } catch(IllegalArgumentException error){
      return ResponseEntity.badRequest().body("Dados Inválido!");
    }
    return ResponseEntity.status(HttpStatus.CREATED).build();

  }

  @PatchMapping(path = "/{id}")
  public ResponseEntity<Void> atualizar(@PathVariable int id,
                                @RequestBody ReceitaRequest request){
    Receita receita = new Receita();
    receita.setId(id);
    receita.setDescricao(request.getDescricao());
    receita.setData(request.getData());
    receita.setReceitaValida(request.getReceitaValida());
    receita.setCliente(clienteRepository.getReferenceById(request.getClienteId()));
    receita.setMedico(medicoRepository.getReferenceById(request.getMedicoId()));
    receita.setPedido(pedidoRepository.getReferenceById(request.getPedidoId()));
    

    try {
      repository.save(receita);
    } catch(IllegalArgumentException error){
      error.printStackTrace();
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok().build();
  }
}
