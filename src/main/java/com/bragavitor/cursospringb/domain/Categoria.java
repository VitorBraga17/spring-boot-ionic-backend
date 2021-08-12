package com.bragavitor.cursospringb.domain;

import java.io.Serializable;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

    public Categoria() {
    
    }

    public Categoria(Integer id, String nome){
        super();
        this.id = id;
        this.nome = nome;
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

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if(getClass() != o.getClass())
            return false;
        Categoria other = (Categoria) o;
        if(id ==null){
            if(other.id != null)
                return false;
        }else 
            if(!id.equals(other.id))
            return false;
        return true;
    }        

}
