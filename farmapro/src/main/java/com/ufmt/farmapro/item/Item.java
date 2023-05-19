package com.ufmt.farmapro.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.pedido.Pedido;
import com.ufmt.farmapro.produto.Produto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="item")
@SequenceGenerator(name = "seqItem", sequenceName = "seq_item_id", allocationSize = 1)
@Getter
@Setter


public class Item {

    @Id
    @GeneratedValue(generator = "seqItem", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "qtd")
    private int qtd;

    @Column(name = "subtotal")
    private double subtotal; 

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;    
    
}
