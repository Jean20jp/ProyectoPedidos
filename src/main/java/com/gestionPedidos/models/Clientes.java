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

    @Column(name = "nom_cli")
    private String nomCli;

    @Column(name = "ape_cli")
    private String apeCli;

    @Column(name = "sal_cli")
    private int salCli;
}
