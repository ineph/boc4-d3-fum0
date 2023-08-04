package com.example.bocadefumoapi.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_DOMINIOS")
public class DominioModel {
    private static final long serialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID guid;
    private String nm_dominio;
    private String nm_origem;
    private String tp_dominio;
    private String descricao;

    public UUID getGuid() {return guid;}
    public void setGuid(UUID guid) {this.guid = guid;}

    public String getNm_dominio() {return nm_dominio;}
    public void setNm_dominio(String nm_dominio) {this.nm_dominio = nm_dominio;}

    public String getNm_origem() {return nm_origem;}
    public void setNm_origem(String nm_origem) {this.nm_origem = nm_origem;}

    public String getTp_dominio() {return tp_dominio;}
    public void setTp_dominio(String tp_dominio) {this.tp_dominio = tp_dominio;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}
}
