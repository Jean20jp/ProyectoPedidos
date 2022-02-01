package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Articulos;
import com.gestionPedidos.services.ArticuloService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticulosController {

    private ArticuloService articuloService;

    public ArticulosController(ArticuloService articuloService) {
        super();
        this.articuloService = articuloService;
    }

    @GetMapping(produces = "application/json")
    public List<Articulos> obtenerArticulos(){
        return articuloService.obtenerArticulos();
    }

    @GetMapping("/articulo")
    public Articulos obtenerArticulos(@RequestParam(name = "idArt") String idArt){
        return articuloService.obtenerArticulo(idArt);
    }

    @PostMapping(produces = "application/json")
    public Articulos ingresarArticulo(@RequestBody @Validated Articulos objArticulo){
        try {
            return articuloService.insertarArticulo(objArticulo);
        }catch (Exception e){
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @PutMapping(produces = "application/json")
    public Articulos actualizarArticulo(@RequestBody @Validated Articulos objArticulo){
        try {
            return articuloService.insertarArticulo(objArticulo);
        }catch (Exception e){
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean eliminarArticulo(@RequestBody @Validated Articulos objArticulo){
        articuloService.eliminarArticulo(objArticulo);
        return true;
    }

}
