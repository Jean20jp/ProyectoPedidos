package com.gestionPedidos.repository;

import com.gestionPedidos.models.DetallePed;
import org.springframework.data.repository.CrudRepository;

public interface DetallePedRepository extends CrudRepository<DetallePed, Integer> {

    DetallePed findDetallePedByIdDet(int idPed);
    void deleteDetallePedByIdDet(int idPed);
}
