package com.gestionPedidos.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detalle_ped")
@AllArgsConstructor
@NoArgsConstructor
public class DetallePed implements Serializable {

    @Id
    @Column(name = "id_ped_per")
    private int idPed;

    @Column(name = "cat_ped")
    private int cant;

    @Column(name = "id_art_ped", length = 5)
    private String idArt;

    public int getIdPed() {
        return idPed;
    }

    public void setIdPed(int idPed) {
        this.idPed = idPed;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }
}
