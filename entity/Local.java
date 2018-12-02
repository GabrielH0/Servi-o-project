package com.firstsoftware.software.entity;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;



@Entity(name="Local")
@Table(name="local",schema = "public")
public class Local {

    @Id
    @Column(name="id_local",columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "complemento")
    private String complemento;
    @Column(name="FK_Rua")
    private int Rua;
    @Column(name="FK_cidade")
    private int cidade;

    public Local() {
    }

    public Local(String complemento, int rua, int cidade) {
        this.complemento = complemento;
        Rua = rua;
        this.cidade = cidade;
    }

    public int getId() {
        return id;
    }

    public String getComplemento() {
        return complemento;
    }

    public int getRua() {
        return Rua;
    }

    public int getCidade() {
        return cidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setRua(int rua) {
        Rua = rua;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }
}
