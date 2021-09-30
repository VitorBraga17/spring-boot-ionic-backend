package com.bragavitor.cursospringb.dto;

import java.io.Serializable;

import com.bragavitor.cursospringb.domain.Produto;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    private String nome;
    private double preco;


    public ProdutoDTO() {
    }

    public ProdutoDTO(Produto obj){
        id = obj.getId();
        nome = obj.getNome();
        preco = obj.getPreco();
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
