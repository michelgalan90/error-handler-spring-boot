package com.galan.springboot.error.app.controllers;

import com.galan.springboot.error.app.exception.UsuarioExcepcion;
import com.galan.springboot.error.app.models.domain.Usuario;
import com.galan.springboot.error.app.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/index")
    public String index(){
        Integer valor = 100/0;
//        var jeje = Integer.parseInt("100jeje");
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model){
        Usuario usuario = usuarioService.obtenerPorId(id);
        /*SI no encuentra un id, usuario sera null, y va explotar abajo llamando al getNombre() */

        if(usuario== null){
            throw new UsuarioExcepcion("El usuario con id " + id + " es nulo porque no existe," +
                    " por favor revise el codigo en la clase" +
                    " AppController.java");
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
        return "ver";
    }

    @GetMapping("/ver/optional/{id}")
    public String verOptional(@PathVariable Integer id, Model model){
        Usuario usuario = usuarioService.obtenerPorIdOptional(id).orElseThrow(() -> {
            throw new UsuarioExcepcion("EL usuario con el id "+ id + " no se encontro");
        });

        model.addAttribute("titulo", "Se encontro el usuario por Optional.of");
        model.addAttribute("usuario", usuario);

       /* usuarioService.obtenerPorIdOptional(id).ifPresentOrElse(usuario -> {
            model.addAttribute("titulo", "Se encontro el usuario por Optional.of");
            model.addAttribute("usuario", usuario);
        }, () -> {
            throw new UsuarioExcepcion("El usuario con el id " + id + " no se encontro");
        });*/

        return "ver-optional";
    }
}
