package com.gestionPedidos.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "articulos")
@AllArgsConstructor
@NoArgsConstructor
public class Articulos implements Serializable {

    @Id
    @Column(name="id_art", length = 5)
    private String idArt;

    @Column (name="nom_art", length = 20)
    private String nomArt;

    @Column (name="pes_art", length = 5)
    private String pesArt;

    public String getIdArt() {
        return idArt;
    }

    public void setIdArt(String idArt) {
        this.idArt = idArt;
    }

    public String getNomArt() {
        return nomArt;
    }

    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }

    public String getPesArt() {
        return pesArt;
    }

    public void setPesArt(String pesArt) {
        this.pesArt = pesArt;
    }
}
