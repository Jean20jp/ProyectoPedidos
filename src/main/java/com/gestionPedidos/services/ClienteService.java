package com.gestionPedidos.services;

import com.gestionPedidos.models.Clientes;
import com.gestionPedidos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService  {

    @Autowired
    private ClienteRepository clientesRepository;

    public List<Clientes> obtenerCliente() {
        return (List<Clientes>) clientesRepository.findAll();
    }

    public Clientes insertarCliente(Clientes objCliente) {
        return (Clientes) clientesRepository.save(objCliente);
    }

    public void eliminarCliente(Clientes objcliente){
        clientesRepository.delete(objcliente);
    }
}