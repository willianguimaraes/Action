
package com.willian.infraestrutura.servico;

import com.willian.infraestrutura.exception.ExcecaoRepositorio;
import com.willian.infraestrutura.exception.ExcecaoServico;
import com.willian.infraestrutura.repositorio.AdapterJpaRepositorio;
import java.io.Serializable;
import java.util.List;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

public abstract class AbstractServico<E> implements Serializable {
    
    protected AdapterJpaRepositorio<E> adapterJpaRepositorio;

    public abstract void inicializar();

    public E salvar(E entidade) throws ExcecaoServico {
        try {
            adapterJpaRepositorio.salvar(entidade);
            return entidade;
        } catch (ExcecaoRepositorio e) {
            throw new ExcecaoServico(e.getMessage());
        }
    }

    public E atualizar(E entidade) throws ExcecaoServico {
        try {
            return adapterJpaRepositorio.atualizar(entidade);
        } catch (ExcecaoRepositorio e) {
            throw new ExcecaoServico(e.getMessage());
        }
    }

    public void excluir(E entidade) throws ExcecaoServico {
        try {
            adapterJpaRepositorio.excluir(entidade);
        } catch (ExcecaoRepositorio e) {
            throw new ExcecaoServico(e.getMessage());
        }
    }

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public List<E> procurarTodos(String ordenarPor) throws ExcecaoServico {
//        try {
//            return adapterJpaRepositorio.consultarTodos(ordenarPor);
//        } catch (ExcecaoRepositorio e) {
//            throw new ExcecaoServico(e.getMessage());
//        }
//    }

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public E procurarPorId(Object id) throws ExcecaoServico {
//        try {
//            if (id == null) {
//                return null;
//            }
//            return (E) adapterJpaRepositorio.consultarPorId(id);
//        } catch (ExcecaoRepositorio e) {
//            throw new ExcecaoServico(e.getMessage());
//        }
//    }

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public List<E> obterPorSituacao(Boolean eSituacao, String ordenarPor) throws ExcecaoServico {
//        try {
//            return adapterJpaRepositorio.consultarPorSituacao(eSituacao, ordenarPor);
//        } catch (ExcecaoRepositorio e) {
//            throw new ExcecaoServico(e.getMessage());
//        }
//    }

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public List<E> obterPorCampo(String campo, Object valor, String ordenarPor) throws ExcecaoServico {
//        try {
//            return adapterJpaRepositorio.consultarPorCampo(campo, valor, ordenarPor);
//        } catch (ExcecaoRepositorio e) {
//            throw new ExcecaoServico(e.getMessage());
//        }
//    }

    public void descarregarParaOBanco() throws ExcecaoServico {
        adapterJpaRepositorio.descarregarParaOBanco();
    }

    public void limparCacheDoGerenciador() throws ExcecaoServico {
        adapterJpaRepositorio.limparCacheDoGerenciador();
    }

//    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
//    public void validarDuplicidade(Integer id, String descricao, String mensagem) throws ExcecaoServico {
//        try {
//            adapterJpaRepositorio.consultarPorDuplicidade(id, descricao, mensagem);
//        } catch (ExcecaoRepositorio e) {
//            throw new ExcecaoServico(e.getMessage());
//        }
//    }
}
