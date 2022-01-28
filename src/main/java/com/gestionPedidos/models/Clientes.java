package com.gestionPedidos.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
public class Clientes implements Serializable {

    @Id
    @Column(name = "id_cli")
    private String idCli;


    @Column(name = "cont_cli")
    private String contCli;

    @Column(name = "nom_cli")
    private String nomCli;

    @Column(name = "ape_cli")
    private String apeCli;

    @Column(name = "sal_cli")
    private int salCli;

    public String getIdCli() {
        return idCli;
    }

    public String getContCli() {
        return contCli;
    }

    public void setContCli(String contCli) {
        this.contCli = contCli;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }

    public String getNomCli() {
        return nomCli;
    }

    public void setNomCli(String nomCli) {
        this.nomCli = nomCli;
    }

    public String getApeCli() {
        return apeCli;
    }

    public void setApeCli(String apeCli) {
        this.apeCli = apeCli;
    }

    public int getSalCli() {
        return salCli;
    }

    public void setSalCli(int salCli) {
        this.salCli = salCli;
    }
}
