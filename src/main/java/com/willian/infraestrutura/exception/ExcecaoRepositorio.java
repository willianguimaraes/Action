package com.willian.infraestrutura.exception;

public class ExcecaoRepositorio extends Exception {

    public ExcecaoRepositorio(String mensagemErro) {
        super(mensagemErro);
    }
}
