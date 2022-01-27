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

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public Date getFec_ped() {
        return fec_ped;
    }

    public void setFec_ped(Date fec_ped) {
        this.fec_ped = fec_ped;
    }

    public String getIdCli() {
        return idCli;
    }

    public void setIdCli(String idCli) {
        this.idCli = idCli;
    }
}
