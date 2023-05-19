package com.ufmt.farmapro.estoque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.lote.Lote;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="estoque")
@SequenceGenerator(name = "seqEstoque", sequenceName = "seq_estoque_id", allocationSize = 1)
@Getter
@Setter

public class Estoque {

    @Id
    @GeneratedValue(generator = "seqEstoque", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "qtd_atual")
    private int qtdAtual;

    @Column(name = "qtd_min")
    private int qtdMin;

    @ManyToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;

}


    