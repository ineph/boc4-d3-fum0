package com.example.bocadefumoapi.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_CLIENTES")
public class ClienteModel {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;

    private String nome;
    private String vulgo;
    private String endereco;
    private Boolean devedor;
    private BigDecimal valor_devido;
    private String obs;

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

    public String getVulgo() {
        return vulgo;
    }

    public void setVulgo(String vulgo) {
        this.vulgo = vulgo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Boolean getDevedor() {
        return devedor;
    }

    public void setDevedor(Boolean devedor) {
        this.devedor = devedor;
    }

    public BigDecimal getValor_devido() {
        return valor_devido;
    }

    public void setValor_devido(BigDecimal valor_devido) {
        this.valor_devido = valor_devido;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
}
