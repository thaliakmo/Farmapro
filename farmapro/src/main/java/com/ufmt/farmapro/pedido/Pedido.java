package com.ufmt.farmapro.pedido;

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
@Table(name="pedido")
@SequenceGenerator(name = "seqPedido", sequenceName = "seq_pedido_id", allocationSize = 1)
@Getter
@Setter

public class Pedido {

    @Id
    @GeneratedValue(generator = "seqPedido", strategy = GenerationType.SEQUENCE)
    private int id; 
    
    @Column(name = "total")
    private float total;
    
}
