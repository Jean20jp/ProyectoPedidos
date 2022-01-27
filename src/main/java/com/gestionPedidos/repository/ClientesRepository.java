package com.gestionPedidos.repository;

import com.gestionPedidos.models.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Clientes,String> {

}
