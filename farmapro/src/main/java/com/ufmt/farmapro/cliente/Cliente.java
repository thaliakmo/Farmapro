package com.ufmt.farmapro.cliente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.pedido.Pedido;
import com.ufmt.farmapro.receita.Receita;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cliente")
@SequenceGenerator(name = "seqCliente", sequenceName = "seq_cliente_id", allocationSize = 1)
@Getter
@Setter

public class Cliente {

    @Id
    @GeneratedValue(generator = "seqCliente", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 120)
    private String nome;

    @Column(name = "email", length = 80)
    private String email;
    
    @Column(name = "endereco", length = 120)
    private String endereco;

    @Column(name = "telefone", length = 14)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Receita> receitas;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
    
    
}
