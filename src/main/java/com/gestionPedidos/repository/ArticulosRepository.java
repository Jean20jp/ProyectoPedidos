package com.gestionPedidos.repository;

import com.gestionPedidos.models.Articulos;
import org.springframework.data.repository.CrudRepository;

public interface ArticulosRepository extends CrudRepository<Articulos, String> {

    Articulos findArticulosByIdArt(String idArt);
    void deleteArticulosByIdArt(String idArt);
}
