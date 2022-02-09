package com.gestionPedidos.repository;

import com.gestionPedidos.models.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, String> {

    Admin findAdminByUserAndAndClave(String id, String clave);
}
