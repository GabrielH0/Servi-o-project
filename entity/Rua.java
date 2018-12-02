package com.firstsoftware.software.entity;

import javax.persistence.*;

@Entity
@Table(name = "rua",schema = "public")
public class Rua {
    @Id
    @Column(name = "id_rua")
    private int id;
    @Column(name="nome_rua")
    private String nome;
    @Column(name = "FK_bairro")
    private int bairro;

    public Rua() {

    }

    public Rua(int id, String nome, int bairro) {
        this.id = id;
        this.nome = nome;
        this.bairro=bairro;
    }

    public void setBairro(int bairro) {
        this.bairro = bairro;
    }

    public int getBairro() {
        return bairro;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
