package com.gestionPedidos.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedidos")
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_ped")
    private int idPed;

    @Column(name = "fec_ped")
    private Date fec_ped;

    @Column(name = "id_cli_per")
    private String idCli;
}
