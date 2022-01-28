package com.gestionPedidos.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.criterion.Restrictions;

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

    public boolean validatePassword(String password) {
        int length = password.length();
        if (length >= 4 && length <= 15 && searchNumeroInPassword(password) && searchMayusInPassword(password))
            return true;
        return false;
    }

    private boolean searchNumeroInPassword(String password) {
        for (Character c : password.toCharArray()) {
            if (c.equals('0') || c.equals('1') || c.equals('2') || c.equals('3') || c.equals('4')
                    || c.equals('5') || c.equals('6') || c.equals('7') || c.equals('8') || c.equals('9') )
                    return true;
        }
        return false;
    }

    private boolean searchMayusInPassword(String password) {
        for (Character c : password.toCharArray()) {
            if (Character.isUpperCase(c))
                return true;
        }
        return false;
    }

    public String getIdCli() {
        return idCli;
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
