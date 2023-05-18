package com.ufmt.farmapro.validadeprod;

import java.util.Date;

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
@Table(name="validade_prod")
@SequenceGenerator(name = "seqValidadeProd", sequenceName = "seq_validade_prod_id", allocationSize = 1)
@Getter
@Setter

public class ValidadeProd {
    
    @Id
    @GeneratedValue(generator = "seqValidadeProd", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "prox_venc")
    private boolean proxVenc;

}
