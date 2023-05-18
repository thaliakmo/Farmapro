package com.ufmt.farmapro.listapedido;

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
@Table(name="lista_pedido")
@SequenceGenerator(name = "seqListaPedido", sequenceName = "seq_lista_pedido_id", allocationSize = 1)
@Getter
@Setter


public class ListaPedido {

    @Id
    @GeneratedValue(generator = "seqListaPedido", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "qtd")
    private int qtd;

    @Column(name = "subtotal")
    private float subtotal; 
    
    
}
