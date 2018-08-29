
package com.willian.infraestrutura.repositorio;

import com.willian.infraestrutura.exception.ExcecaoRepositorio;
import com.willian.infraestrutura.interfaces.IRepositorio;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AdapterJpaRepositorio<T> implements IRepositorio<T>, Serializable  {

    private static final Logger LOG = Logger.getLogger(AdapterJpaRepositorio.class.getName());
    
    @PersistenceContext(unitName = "projeto_financeiro")
    protected EntityManager entityManager;

    /* Armazena a classe de entidade correspondente a dao */
    protected Class<T> entidade;
  
    /**
     * Adiciona a referencia automaticamente por generics
     */
    public AdapterJpaRepositorio() {
        this.entidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    @Override
    public void salvar(T entidade) throws ExcecaoRepositorio {
        try {
            entityManager.persist(entidade);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new ExcecaoRepositorio(e.getMessage());
        }
    }

    @Override
    public T atualizar(T entidade) throws ExcecaoRepositorio {
        try {
            return entityManager.merge(entidade);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new ExcecaoRepositorio(e.getMessage());
        }
    }

	@Override
    public void excluir(T entidade) throws ExcecaoRepositorio {
        try {
            entityManager.remove(entityManager.merge(entidade));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
            throw new ExcecaoRepositorio(e.getMessage());
        }
    }

//    @Override
//    public T consultarPorId(Object id) throws ExcecaoRepositorio {
//        try {
//            return (T) entityManager.find(entidade, id);
//        } catch (NoResultException noResultException) {
//            throw new ExcecaoRepositorio(noResultException.getMessage());
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, e.getMessage(), e);
//            throw new ExcecaoRepositorio(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<T> consultarTodos(final String ordenarPor) throws ExcecaoRepositorio {
//        try {
//            return entityManager.createQuery("SELECT obj FROM " + entidade.getSimpleName() + " obj "
//                    + "ORDER BY obj." + ordenarPor)
//                    .getResultList();
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, e.getMessage(), e);
//            throw new ExcecaoRepositorio(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<T> consultarPorSituacao(Boolean eSituacao, String ordenarPor) throws ExcecaoRepositorio {
//        try {
//            return entityManager.createQuery("SELECT obj FROM " + entidade.getSimpleName() + " obj "
//                    + "WHERE obj.situacao = :_situacao "
//                    + "ORDER BY obj." + ordenarPor)
//                    .setParameter("_situacao", eSituacao)
//                    .getResultList();
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, e.getMessage(), e);
//            throw new ExcecaoRepositorio(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<T> consultarPorCampo(String campo, Object valor, String ordenarPor) throws ExcecaoRepositorio {
//        try {
//            return entityManager.createQuery("SELECT obj FROM " + entidade.getSimpleName() + " obj"
//                    + " WHERE obj." + campo + " =:_valor"
//                    + " ORDER BY obj." + ordenarPor)
//                    .setParameter("_valor", valor)
//                    .getResultList();
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, e.getMessage(), e);
//            throw new ExcecaoRepositorio(e.getMessage());
//        }
//    }
//
//    @Override
//    public void consultarPorDuplicidade(Integer id, String descricao, String mensagem) throws ExcecaoRepositorio {
//        if (id == null) {
//            if (validarDuplicidadeAoSalvar(descricao)) {
//                throw new ExcecaoRepositorio(mensagem);
//            }
//        } else {
//            if (validarDuplicidadeAoAtualizar(id, descricao)) {
//                throw new ExcecaoRepositorio(mensagem);
//            }
//        }
//    }
//
//    @Override
//    public boolean validarDuplicidadeAoSalvar(String descricao) {
//        try {
//            entityManager.createQuery("SELECT obj FROM " + entidade.getName() + " obj WHERE obj.descricao =:_descricao")
//                    .setParameter("_descricao", descricao)
//                    .getSingleResult();
//            return true;
//        } catch (NoResultException noResultException) {
//            return false;
//        }
//    }
//
//    @Override
//    public boolean validarDuplicidadeAoAtualizar(Integer id, String descricao) {
//        try {
//            entityManager.createQuery("SELECT obj FROM  " + entidade.getName() + " obj WHERE obj.descricao =:_descricao AND obj.id <>:_id")
//                    .setParameter("_descricao", descricao)
//                    .setParameter("_id", id)
//                    .getSingleResult();
//            return true;
//        } catch (NoResultException noResultException) {
//            return false;
//        }
//    }

    public void desacoplarDoGerenciadorDeObjetos(T t) {
        try {
            entityManager.detach(t);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void descarregarParaOBanco() {
        try {
            entityManager.flush();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public void limparCacheDoGerenciador() {
        try {
            entityManager.clear();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }
}
