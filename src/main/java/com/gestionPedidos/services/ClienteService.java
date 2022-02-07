package com.gestionPedidos.services;

import com.gestionPedidos.models.Articulos;
import com.gestionPedidos.models.Clientes;
import com.gestionPedidos.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClienteService  {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> obtenerClientes() {
        return (List<Clientes>) clientesRepository.findAll();
    }

    public Clientes obtenerCliente(String idCli){
        return clientesRepository.findClienteByIdCli(idCli);
    }

    public Clientes insertarCliente(Clientes objCliente) {
        return (Clientes) clientesRepository.save(objCliente);
    }

    public void eliminarCliente(String idCli){
        clientesRepository.deleteClienteByIdCli(idCli);
    }
}