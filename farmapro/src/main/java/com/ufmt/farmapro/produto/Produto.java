package com.ufmt.farmapro.produto;

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

import com.ufmt.farmapro.fornecedor.Fornecedor;
import com.ufmt.farmapro.item.Item;
import com.ufmt.farmapro.lote.Lote;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="produto")
@SequenceGenerator(name = "seqProduto", sequenceName = "seq_produto_id", allocationSize = 1)
@Getter
@Setter


public class Produto {

    @Id
    @GeneratedValue(generator = "seqProduto", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "nome", length = 200)
    private String nome;

    @Column(name = "descricao", length = 400)
    private String descricao;

    @Column(name = "valor")
    private double valor;

    @OneToMany(mappedBy = "produto")
    private List<Item> itens;

    @OneToMany(mappedBy = "produto")
    private List<Lote> lotes;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

}
