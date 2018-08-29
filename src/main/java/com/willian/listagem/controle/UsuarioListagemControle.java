package com.willian.listagem.controle;

import com.willian.infraestrutura.interfaces.IListagemControle;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ViewScoped
@Named
public class UsuarioListagemControle implements IListagemControle {
    @PostConstruct
    @Override
    public void inicializar() {
       
    }
    
    @Override
    public void listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
