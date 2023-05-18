package com.ufmt.farmapro.funcionario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="funcionario")
@SequenceGenerator(name = "seqFuncionario", sequenceName = "seq_funcionario_id", allocationSize = 1)
@Getter
@Setter

public class Funcionario {

    @Id
    @GeneratedValue(generator = "seqFuncionario", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "email", length = 200)
    private String email;
    
    @Column(name = "endereco", length = 400)
    private String endereco;

    @Column(name = "telefone", length = 14)
    private String telefone;
    
}
