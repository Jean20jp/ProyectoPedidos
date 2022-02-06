package com.gestionPedidos.models.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    private String idUser;
    private String nombre;
    private String apellido;
    private int saldo;
    private String password;

    public Usuario(String idUser, String nombre, String apellido, int saldo, String password) {
        this.idUser = idUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.saldo = saldo;
        this.password = password;
    }

    public Usuario(){
        super();
    }

    public String getIdUser() {
        return idUser;
    }

    public void setId(String idUser) {
        this.idUser = idUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
