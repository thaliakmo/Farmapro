package com.ufmt.farmapro.fornecedor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.produto.Produto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="fornecedor")
@SequenceGenerator(name = "seqFornecedor", sequenceName = "seq_fornecedor_id", allocationSize = 1)
@Getter
@Setter

public class Fornecedor {

    @Id
    @GeneratedValue(generator = "seqFornecedor", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "email", length = 200)
    private String email;
    
    @Column(name = "endereco", length = 400)
    private String endereco;

    @Column(name = "telefone", length = 14)
    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos;
    
}
