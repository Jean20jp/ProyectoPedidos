package com.gestionPedidos.services;

import com.gestionPedidos.models.Admin;
import com.gestionPedidos.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin validarAdmin(String id, String clave){
        return adminRepository.findAdminByUserAndAndClave(id, clave);
    }
}
