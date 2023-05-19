package com.ufmt.farmapro.medico;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.farmapro.receita.Receita;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="medico")
@SequenceGenerator(name = "seqMedico", sequenceName = "seq_medico_id", allocationSize = 1)
@Getter
@Setter


public class Medico {

    @Id
    @GeneratedValue(generator = "seqMedico", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "crm")
    private int crm;

    @OneToMany(mappedBy = "medico")
    private List<Receita> receitas;
 
}
