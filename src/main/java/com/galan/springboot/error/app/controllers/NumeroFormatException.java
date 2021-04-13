package com.galan.springboot.error.app.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class NumeroFormatException {

//    @ExceptionHandler(NumberFormatException.class)
    public String errorNumero(Exception e, Model model){
        model.addAttribute("error", "Error de formato de numero");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("cause", e.getCause());
        return "error/numero";
    }

}
