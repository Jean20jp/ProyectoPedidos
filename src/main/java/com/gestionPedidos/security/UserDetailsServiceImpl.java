package com.gestionPedidos.security;

import com.gestionPedidos.models.dao.IUsuarioDAO;
import com.gestionPedidos.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String idUser) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByIdUser(idUser);
        UserBuilder builder = null;
        if (usuario != null) {
            builder = User.withUsername(idUser);
            builder.disabled(false);
            builder.password(usuario.getPassword());
            builder.authorities(new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return builder.build();
    }
}
