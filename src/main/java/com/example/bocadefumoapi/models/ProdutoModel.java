package com.example.bocadefumoapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS")
public class ProdutoModel {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID guid;
    private String nome;
    private BigDecimal valor;

    public UUID getGuid() {
        return guid;
    }

    public void setGuid(UUID guid) {
        this.guid = guid;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}



