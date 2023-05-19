package com.ufmt.farmapro.lote;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ufmt.farmapro.estoque.Estoque;
import com.ufmt.farmapro.produto.Produto;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="lote")
@SequenceGenerator(name = "seqLote", sequenceName = "seq_lote_id", allocationSize = 1)
@Getter
@Setter

public class Lote {
    
    @Id
    @GeneratedValue(generator = "seqLote", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "prox_venc")
    private boolean proxVenc;

    @OneToMany(mappedBy = "lote")
    private List<Estoque> estoque;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;


}
