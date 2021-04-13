package com.galan.springboot.error.app.services;

import com.galan.springboot.error.app.models.domain.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    private List<Usuario> lista;

    public UsuarioServiceImplement() {
        this.lista = new ArrayList<>();
        lista.add(new Usuario(1, "Andres", "Guzman"));
        lista.add(new Usuario(2, "Pepa", "Garcia"));
        lista.add(new Usuario(3, "Lalo", "Mena"));
        lista.add(new Usuario(4, "Luci", "Fernandez"));
        lista.add(new Usuario(5, "Paco", "Rodriguez"));
        lista.add(new Usuario(6, "Juan", "Gomez"));
    }

    @Override
    public List<Usuario> listar() {
        return lista;
    }

    @Override
    public Usuario obtenerPorId(Integer id) {
        Usuario resultado = null;
        for(Usuario u: lista){
            if(u.getId().equals(id)){
                resultado = u;
                break;
            }
        }
        return resultado;
    }

    @Override
    public Optional<Usuario> obtenerPorIdOptional(Integer id) {
        Usuario usuario = obtenerPorId(id);

        Optional<Usuario> optional = Optional.ofNullable(usuario);

        return optional;
    }
}
