package com.firstsoftware.software.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta",schema = "public")
public class Conta {
    @Id
    private int numero;
    private String banco;
    private String agencia;

    public Conta(){

    }
    public Conta(int numero, String banco, String agencia) {
        this.numero = numero;
        this.banco = banco;
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public String getBanco() {
        return banco;
    }

    public String getAgencia() {
        return agencia;
    }
}
