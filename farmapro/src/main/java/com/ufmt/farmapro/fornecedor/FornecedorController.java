package com.ufmt.farmapro.fornecedor;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/fornecedor")
@RequiredArgsConstructor

public class FornecedorController {


    private final FornecedorRepository fornecedorRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }
    
}