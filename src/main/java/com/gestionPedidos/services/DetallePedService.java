package com.gestionPedidos.services;

import com.gestionPedidos.models.DetallePed;
import com.gestionPedidos.repository.DetallePedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedService {

    @Autowired
    private DetallePedRepository detallePedRepository;

    public List<DetallePed> obtenerDetallePed() {
        return (List<DetallePed>) detallePedRepository.findAll();
    }

    public DetallePed insertarDetallePed(DetallePed objDetallePed) {
        return (DetallePed) detallePedRepository.save(objDetallePed);
    }

    public void eliminarDetallePed(DetallePed objDetallePed) {
        detallePedRepository.delete(objDetallePed);
    }

}
