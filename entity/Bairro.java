package com.firstsoftware.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bairro",schema = "public")
public class Bairro {

    @Id
    @Column(name="id_bairro")
    private int id;
    @Column(name="nome_bairro")
    private String nome;
    @Column(name="FK_cidade")
    private int cidade;

    public Bairro() {
    }

    public Bairro(int id, String nome, int cidade) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getCidade() {
        return cidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
