package com.ufmt.farmapro.receita;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ufmt.farmapro.cliente.Cliente;
import com.ufmt.farmapro.medico.Medico;
import com.ufmt.farmapro.pedido.Pedido;

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

    @Column(name = "descricao", length = 400)
    private String descricao;

    @Column(name = "receita_valida")
    private boolean receitaValida;


    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public void setData(java.util.Date data2) {
    }
    
}
