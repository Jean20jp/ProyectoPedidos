package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Articulos;
import com.gestionPedidos.services.ArticulosService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articulos")
public class ArticulosController {

    private ArticulosService articulosService;

    public ArticulosController(ArticulosService articulosService) {
        super();
        this.articulosService = articulosService;
    }

    @GetMapping(produces = "application/json")
    public List<Articulos> obtenerArticulos(){
        return articulosService.obtenerArticulos();
    }

    @PostMapping(produces = "application/json")
    public Articulos ingresarArticulo(@RequestBody @Validated Articulos objArticulo){
        try {
            return articulosService.insertarArticulo(objArticulo);
        }catch (Exception e){
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @PutMapping(produces = "application/json")
    public Articulos actualizarArticulo(@RequestBody @Validated Articulos objArticulo){
        try {
            return articulosService.insertarArticulo(objArticulo);
        }catch (Exception e){
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean eliminarArticulo(@RequestBody @Validated Articulos objArticulo){
        articulosService.eliminarArticulo(objArticulo);
        return true;
    }

}
