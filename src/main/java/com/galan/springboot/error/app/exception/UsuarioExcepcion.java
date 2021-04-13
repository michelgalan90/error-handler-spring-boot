package com.galan.springboot.error.app.exception;


public class UsuarioExcepcion extends RuntimeException{
    public UsuarioExcepcion(String message) {
        super(message);
    }
}
