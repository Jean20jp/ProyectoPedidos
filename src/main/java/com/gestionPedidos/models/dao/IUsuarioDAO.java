package com.gestionPedidos.models.dao;

import com.gestionPedidos.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, String> {

    public Usuario findByIdUser(String id);
}
