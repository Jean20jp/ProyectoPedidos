package com.gestionPedidos.repository;

import com.gestionPedidos.models.Pedidos;
import org.springframework.data.repository.CrudRepository;

public interface PedidosRepository extends CrudRepository<Pedidos, Integer> {
}
