package com.firstsoftware.software.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name="servico")
@Table(name = "servico",schema = "public")
public class Servico {
    @Id
    @Column(name="id_servico",columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;
    @Column(name="nome_servico")
    @NotNull
    private String nome;
    @Column(name="FK_fornecedor")
    @NotNull
    private String fornecedor;
    @Column(name="FK_local")
    @NotNull
    private int local;
    @Column(name="numero_pessoas")
    @NotNull
    private int numeroPessoas;
    @Column(name="descricao_servico")
    @NotNull
    private String descricao;
    @Column(name = "FK_categoria")
    @NotNull
    private int categoria;
    @Column(name = "Data_post")
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_post;
    @Column(name = "Data_servico")
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String data_servico;
    @Column(name = "Valor_servico")
    @NotNull
    private float valor;
    @Column(name="horario_servico")
    @NotNull
    private String horario;

    public Servico(){

    }

    public Servico(@NotNull String nome, @NotNull String fornecedor, @NotNull int local, @NotNull int numeroPessoas, @NotNull String descricao, @NotNull int categoria, @NotNull Date data_post, @NotNull String data_servico, @NotNull float valor, @NotNull String horario) {
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.local = local;
        this.numeroPessoas = numeroPessoas;
        this.descricao = descricao;
        this.categoria = categoria;
        this.data_post = data_post;
        this.data_servico = data_servico;
        this.valor = valor;
        this.horario = horario;
    }

    public void setData_post(Date data_post) {
        this.data_post = data_post;
    }

    public void setData_servico(String data_servico) {
        this.data_servico = data_servico;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Date getData_post() {
        return data_post;
    }

    public String getData_servico() {
        return data_servico;
    }

    public float getValor() {
        return valor;
    }

    public String getHorario() {
        return horario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public int getLocal() {
        return local;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getCategoria() {
        return categoria;
    }
}
