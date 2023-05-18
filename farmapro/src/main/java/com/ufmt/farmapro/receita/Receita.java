package com.ufmt.farmapro.receita;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="receita")
@SequenceGenerator(name = "seqReceita", sequenceName = "seq_receita_id", allocationSize = 1)
@Getter
@Setter

public class Receita {

    @Id
    @GeneratedValue(generator = "seqReceita", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "receita_valida")
    private boolean receitaValida;
    
}
