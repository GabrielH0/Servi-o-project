package com.firstsoftware.software.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidade",schema = "public")
public class Cidade {

    @Id
    @Column(name="id_cidade")
    private int id;
    @Column(name="nome_cidade")
    private String nome;
    @Column(name="Fk_estado")
    private int estado;

    public Cidade() {
    }

    public Cidade(int id, String nome, int estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getEstado() {
        return estado;
    }
}
