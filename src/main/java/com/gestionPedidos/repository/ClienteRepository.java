package com.gestionPedidos.repository;

import com.gestionPedidos.models.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Clientes,String> {

}
