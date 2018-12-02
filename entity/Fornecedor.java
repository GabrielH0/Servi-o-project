package com.firstsoftware.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="fornecedor")
@Table(name = "fornecedor",schema = "public")
public class Fornecedor {
    @Id
    @Column(name="FK_usuario")
    private String usuario;
    @Column(name="fornecedor_conta")
    private int conta;
    @Column(name = "area_atuacao")
    private String areaAtuacao;
    @Column(name = "descricao_fornecedor")
    private String descricao;

    public Fornecedor() {
    }

    public Fornecedor(String usuario, int conta, String areaAtuacao, String descricao) {
        this.usuario = usuario;
        this.conta = conta;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getConta() {
        return conta;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
