package com.gestionPedidos.controllers;

import com.gestionPedidos.models.DetallePed;
import com.gestionPedidos.services.DetallePedService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_ped")
public class DetallePedController {

    private DetallePedService detallePedService;

    public DetallePedController(DetallePedService detallePedService) {
        super();
        this.detallePedService = detallePedService;
    }

    @GetMapping(produces = "application/json")
    public List<DetallePed> obtenerDetallePed() {
        return detallePedService.obtenerDetallePed();
    }

    @GetMapping("/detalle")
    public DetallePed obtenerDetalle(@RequestParam(name = "idDet") int idDed){
        return detallePedService.obtenerDetallePed(idDed);
    }

    @PostMapping(produces = "application/json")
    public DetallePed ingresarDetallePed(@RequestBody @Validated DetallePed objDetallePed) {
        try {
            return detallePedService.insertarDetallePed(objDetallePed);
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @PutMapping(produces = "application/json")
    public DetallePed actualizarDetallePed(@RequestBody @Validated DetallePed objDetallePed) {
        try {
            return detallePedService.insertarDetallePed(objDetallePed);
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @DeleteMapping
    public boolean eliminarArticulo(@RequestParam(name = "idDet") int idDet){
        detallePedService.eliminarDetallePed(idDet);
        return true;
    }
}
