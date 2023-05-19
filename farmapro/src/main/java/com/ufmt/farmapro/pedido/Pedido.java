package com.ufmt.farmapro.pedido;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.cliente.Cliente;
import com.ufmt.farmapro.funcionario.Funcionario;
import com.ufmt.farmapro.item.Item;
import com.ufmt.farmapro.receita.Receita;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pedido")
@SequenceGenerator(name = "seqPedido", sequenceName = "seq_pedido_id", allocationSize = 1)
@Getter
@Setter

public class Pedido {

    @Id
    @GeneratedValue(generator = "seqPedido", strategy = GenerationType.SEQUENCE)
    private int id; 
    
    @Column(name = "total")
    private double total;

    @OneToMany(mappedBy = "pedido")
    private List<Receita> receitas;

    @OneToMany(mappedBy = "pedido")
    private List<Item> itens;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

}
