package com.gestionPedidos.models.impl;

import com.gestionPedidos.models.dao.IUsuarioDAO;
import com.gestionPedidos.models.entity.Usuario;
import com.gestionPedidos.models.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario findByIdUser(String idUser) {
        return usuarioDao.findByIdUser(idUser);
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioDao.save(usuario);
    }
}
