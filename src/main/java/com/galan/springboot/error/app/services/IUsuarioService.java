package com.galan.springboot.error.app.services;

import com.galan.springboot.error.app.models.domain.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {

    public List<Usuario> listar();

    Usuario obtenerPorId(Integer id);
    Optional<Usuario> obtenerPorIdOptional(Integer id);
}
