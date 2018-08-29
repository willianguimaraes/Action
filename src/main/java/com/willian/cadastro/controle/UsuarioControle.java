package com.willian.cadastro.controle;

import com.willian.dominio.modelo.Usuario;
import com.willian.dominio.servico.UsuarioServico;
import com.willian.infraestrutura.exception.ExcecaoServico;
import com.willian.infraestrutura.interfaces.ICadastroControle;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ViewScoped
@Named
public class UsuarioControle implements ICadastroControle {

    @Inject
    private UsuarioServico usuarioServico;
    
    private Usuario usuario;
    
    @PostConstruct
    @Override
    public void inicializar() {
        usuario = new Usuario();

    }

    private boolean validaUsuario() {
        return !(usuario.getNome().equals("") && usuario.getEmail().equals("") && usuario.getCpf().equals(""));

    }

    @Override
    public String salvar(String paginaRedirecionamento) {
        Date data = new Date();
        if (validaUsuario()) {
            try {
                usuario.setDataCadastro(data);
                usuarioServico.salvar(usuario);
            } catch (ExcecaoServico ex) {
                Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Preencha todos os campos marcados com * ", null));

            }
        }
        return "";
    }
}
