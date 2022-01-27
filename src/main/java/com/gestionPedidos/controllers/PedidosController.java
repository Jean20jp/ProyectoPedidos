package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Pedidos;
import com.gestionPedidos.services.PedidoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {

    private PedidoService pedidoService;

    public PedidosController(PedidoService pedidoService) {
        super();
        this.pedidoService = pedidoService;
    }

    @GetMapping(produces = "application/json")
    public List<Pedidos> obtenerPedidos() {
        return pedidoService.obtenerPedido();
    }

    @PostMapping(produces = "application/json")
    public Pedidos ingresarPedido(@RequestBody @Validated Pedidos objPedido) {
        try {
            return pedidoService.insertarPedido(objPedido);
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @PutMapping(produces = "application/json")
    public Pedidos actualizarPedido(@RequestBody @Validated Pedidos objPedido) {
        try {
            return pedidoService.insertarPedido(objPedido);
        } catch (Exception e) {
            System.out.println("Error en el ingreso de datos" + e);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean eliminarPedido(@RequestBody @Validated Pedidos objPedido) {
        pedidoService.eliminarPedido(objPedido);
        return true;
    }

}
