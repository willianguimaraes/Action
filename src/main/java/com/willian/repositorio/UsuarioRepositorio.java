/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.willian.repositorio;

import com.willian.dominio.modelo.Usuario;
import com.willian.infraestrutura.repositorio.AdapterJpaRepositorio;

public class UsuarioRepositorio extends AdapterJpaRepositorio<Usuario> {

    public Usuario obterPorId(Integer id) {
        return (Usuario) entityManager.createQuery("Select u FROM Usuario u where u.id =:_id").setParameter("_id", id).getSingleResult();
    }
    
}
