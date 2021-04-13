package com.galan.springboot.error.app.controllers;


import com.galan.springboot.error.app.exception.UsuarioExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = ArithmeticException.class)
    public String aritmeticaError(ArithmeticException exception, Model model){
        model.addAttribute("error", "Error de aritmetica");
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/generica";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatError(NumberFormatException e, Model model){
        model.addAttribute("error", "Error: FOrmato numero invalido!");
        model.addAttribute("message", e.getMessage());

        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/numero-formato";
    }

    @ExceptionHandler(UsuarioExcepcion.class)
    public String usuarioError(Exception e, Model model){
        model.addAttribute("titulo", "Error de tipo UsuarioExcepcion");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("timestamp", new Date());

        return "error/usuario-error";
    }

}
