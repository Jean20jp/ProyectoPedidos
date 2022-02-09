package com.gestionPedidos.services;

import com.gestionPedidos.models.DetallePed;
import com.gestionPedidos.repository.DetallePedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DetallePedService {

    @Autowired
    private DetallePedRepository detallePedRepository;

    public List<DetallePed> obtenerDetallePed() {
        return (List<DetallePed>) detallePedRepository.findAll();
    }

    public DetallePed obtenerDetallePed(int idPed){
        return detallePedRepository.findDetallePedByIdDet(idPed);
    }

    public DetallePed insertarDetallePed(DetallePed objDetallePed) {
        return (DetallePed) detallePedRepository.save(objDetallePed);
    }

    public void eliminarDetallePed(int DetallePed) {
        detallePedRepository.deleteDetallePedByIdDet(DetallePed);
    }

}
