package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Clientes;
import com.gestionPedidos.services.ClienteService;
import com.gestionPedidos.utils.ModelUtils;
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
        return clienteService.obtenerClientes();
    }

    @GetMapping("/cliente")
    public Clientes obtenerClientes(@RequestParam(name = "idCli") String idArt){
        return clienteService.obtenerCliente(idArt);
    }

    @PostMapping(produces = "application/json")
    public Clientes ingresarCliente(@RequestBody @Validated Clientes objCliente) {
        try {
            validarDatosCliente(objCliente);
            return clienteService.insertarCliente(objCliente);
        } catch (Exception e) {
            System.out.println("Error en el ingresar de datos" + e);
            return  null;
        }
    }

    @PutMapping(produces = "application/json")
    public Clientes actualizarCliente(@RequestBody @Validated Clientes objCliente) {
        try {
            validarPassword(objCliente);
            return clienteService.insertarCliente(objCliente);
        } catch (Exception e) {
            System.out.println("Error en el ingresar de datos" + e);
            return  null;
        }
    }

    @DeleteMapping
    public boolean eliminarCliente(@RequestParam(name = "idCli") String idCli) {
        clienteService.eliminarCliente(idCli);
        return true;
    }

    private void validarDatosCliente(Clientes objCliente) throws Exception {
        if (!ModelUtils.validadorDeCedula(objCliente.getIdCli()))
            throw new Exception("Cedula Incorrecta");
        if (!ModelUtils.esSoloLetras(objCliente.getNomCli()))
            throw new Exception("Nombre No Valido");
        if (!ModelUtils.esSoloLetras(objCliente.getApeCli()))
            throw new Exception("Apellido No Valido");
        if (!ModelUtils.validatePassword(objCliente.getContCli()))
            throw new Exception("Contraseña no valida");
    }

    private void validarPassword(Clientes objCliente) throws Exception {
        if (!ModelUtils.validatePassword(objCliente.getContCli()))
            throw new Exception("Contraseña no valida");
    }
}
