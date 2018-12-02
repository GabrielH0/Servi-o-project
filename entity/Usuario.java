package com.firstsoftware.software.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity(name = "usuario")
@Table(name = "usuario",schema = "public")
public class Usuario {


    @Id
    //@CPF(message = "{cpf.not.valid")
    @NotBlank(message="{cpf.not.blank}")
    @Column(name="cpf")
    private String  cpf;
    @NotBlank(message= "{name.not.blank}")
    @Column(name="nome_usuario")
    private String nome;
    @Column(name="tipo_usuario")
    private int tipoUsuario;
    @NotBlank(message = "{senha.not.blank}")
    @Column(name="senha")
    private String senha;
    @NotBlank(message = "{email.not.blank}")
    @Column(name="email")
    private String email;

    public Usuario(){

    }
    public Usuario(String cpf, String nome,String senha,String email, int tipoUsuario) {
        this.cpf = cpf;
        this.nome= nome;
        this.tipoUsuario = tipoUsuario;
        this.senha=senha;
        this.email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome_usuario() {
        return nome;
    }


    public int getTipoUsuario() {
        return tipoUsuario;
    }
}
