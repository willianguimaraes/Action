/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.willian.dominio.servico;

import com.willian.dominio.modelo.Usuario;
import com.willian.infraestrutura.servico.AbstractServico;
import com.willian.repositorio.UsuarioRepositorio;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServico  extends AbstractServico<Usuario>{

    @Inject
    private UsuarioRepositorio usuarioRepositorio;
    
    @PostConstruct
    @Override
    public void inicializar() {
         adapterJpaRepositorio = usuarioRepositorio;
    }
    
    
    public Usuario ObterUsuarioPorId(Integer id){
        return usuarioRepositorio.obterPorId(id);
    }
    
    
}
