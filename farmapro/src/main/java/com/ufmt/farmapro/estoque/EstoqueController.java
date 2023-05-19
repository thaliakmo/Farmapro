package com.ufmt.farmapro.estoque;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/estoque")
@RequiredArgsConstructor

public class EstoqueController {


    private final EstoqueRepository estoqueRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Estoque> findAll(){
        return estoqueRepository.findAll();
    }
    
}
