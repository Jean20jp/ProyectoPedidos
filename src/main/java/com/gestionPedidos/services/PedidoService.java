package com.gestionPedidos.services;

import com.gestionPedidos.models.Pedidos;
import com.gestionPedidos.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public List<Pedidos> obtenerPedido() {
        return (List<Pedidos>) pedidosRepository.findAll();
    }

    public Pedidos insertarPedido(Pedidos objPedido) {
        return (Pedidos) pedidosRepository.save(objPedido);
    }

    public void eliminarPedido(Pedidos objPedido) {
        pedidosRepository.delete(objPedido);
    }
}
