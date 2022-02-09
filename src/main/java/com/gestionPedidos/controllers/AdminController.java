package com.gestionPedidos.controllers;

import com.gestionPedidos.models.Admin;
import com.gestionPedidos.models.Clientes;
import com.gestionPedidos.services.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService) {
        super();
        this.adminService = adminService;
    }

    @GetMapping("/validar")
    public Admin validarCliente(@RequestParam(name = "user") String user, @RequestParam(name = "clave") String clave){
        return adminService.validarAdmin(user, clave);
    }
}
