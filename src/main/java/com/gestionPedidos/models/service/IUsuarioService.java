package com.gestionPedidos.models.service;

import com.gestionPedidos.models.entity.Usuario;

public interface IUsuarioService {

    public Usuario findByIdUser(String idUser);
    public Usuario registrar(Usuario usuario);
}
