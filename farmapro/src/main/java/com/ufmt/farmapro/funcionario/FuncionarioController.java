package com.ufmt.farmapro.funcionario;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor

public class FuncionarioController {


    private final FuncionarioRepository funcionarioRepository;

    @GetMapping
    @Transactional(readOnly = true)
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
    
}
