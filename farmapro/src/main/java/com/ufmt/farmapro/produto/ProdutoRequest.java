package com.ufmt.farmapro.produto;

public class ProdutoRequest {
    private String nome;
    private String descricao;
    private double valor;
    private int fornecedorId;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }
    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

}
