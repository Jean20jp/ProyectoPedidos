package com.gestionPedidos.services;

import com.gestionPedidos.models.Pedidos;
import com.gestionPedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PedidoService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> obtenerPedido() {
        return (List<Pedidos>) pedidosRepository.findAll();
    }

    public Pedidos obtenerPedidoByCed(String cedula){
        return pedidosRepository.findPedidosByIdCli(cedula);
    }

    public Pedidos insertarPedido(Pedidos objPedido) {
        return (Pedidos) pedidosRepository.save(objPedido);
    }

    public void eliminarPedido(int objPedido) {
        pedidosRepository.deletePedidosByIdPed(objPedido);
    }
}
