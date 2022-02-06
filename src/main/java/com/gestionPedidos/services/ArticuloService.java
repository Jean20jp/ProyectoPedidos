package com.gestionPedidos.services;

import com.gestionPedidos.models.Articulos;
import com.gestionPedidos.repository.ArticulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticuloService {

    @Autowired
    private ArticulosRepository articulosRepository;

    public List<Articulos> obtenerArticulos(){
        return (List<Articulos>) articulosRepository.findAll();
    }

    public Articulos obtenerArticulo(String idArt){
        return articulosRepository.findArticulosByIdArt(idArt);
    }

    public Articulos insertarArticulo(Articulos objArticulo){
        return (Articulos) articulosRepository.save(objArticulo);
    }

    public void eliminarArticulo(String idArt){
        articulosRepository.deleteArticulosByIdArt(idArt);
    }
}
