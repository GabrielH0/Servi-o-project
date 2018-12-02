package com.firstsoftware.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado",schema = "public")
public class Uf {

    @Id
    @Column(name = "id_estado")
    private int id;
    @Column(name = "nome_estado")
    private String nome;
    @Column
    private String UF;

    public Uf() {
    }

    public Uf(int id, String nome, String UF) {
        this.nome = nome;
        this.UF = UF;
        this.id=id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUF() {
        return UF;
    }
}
