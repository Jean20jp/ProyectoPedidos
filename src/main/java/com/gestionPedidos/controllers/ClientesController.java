package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Clientes;
import com.gestionPedidos.services.ClienteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        super();
        this.clienteService = clienteService;
    }

    @GetMapping(produces = "application/json")
    public List<Clientes> obtenerClientes() {
        return clienteService.obtenerCliente();
    }

    @PostMapping(produces = "application/json")
    public Clientes ingresarCliente(@RequestBody @Validated Clientes objCliente) {
        try {
            return clienteService.insertarCliente(objCliente);
        } catch (Exception e) {
            System.out.println("Error en el ingresar de datos" + e);
            return  null;
        }
    }

    @PutMapping(produces = "application/json")
    public Clientes actualizarCliente(@RequestBody @Validated Clientes objCliente) {
        try {
            return clienteService.insertarCliente(objCliente);
        } catch (Exception e) {
            System.out.println("Error en el ingresar de datos" + e);
            return  null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public boolean eliminarCliente(@RequestBody @Validated Clientes objCliente) {
        clienteService.eliminarCliente(objCliente);
        return true;
    }

}
