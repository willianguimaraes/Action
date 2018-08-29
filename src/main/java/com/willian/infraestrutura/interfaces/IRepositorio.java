package com.willian.infraestrutura.interfaces;

import com.willian.infraestrutura.exception.ExcecaoRepositorio;
import java.util.List;

public interface IRepositorio<T> {
    
    /**
     * Deleta uma entidade
     * @param entidade
     * @return
     * @throws com.willian.infraestrutura.exception.ExcecaoRepositorio
     */
    public void excluir(T entidade) throws ExcecaoRepositorio;

//    /**
//     * Retorna uma lista de entidades
//     * @param ordenarPor
//     * @return
//     * @throws com.willian.infraestrutura.exception.ExcecaoRepositorio
//     */
//    public List<T> consultarTodos(String ordenarPor) throws ExcecaoRepositorio;
//
//    /**
//     * Recupera uma entidade
//     * @param id da entidade
//     * @return entidade
//     */
//    public T consultarPorId(Object id) throws ExcecaoRepositorio;
//    
    /**
     * Salva uma entidade
     * @param entidade
     * @throws ExceptionDAO 
     */
    public void salvar(T entidade) throws ExcecaoRepositorio;

    /**
     * Atualiza uma entidade
     * @param entidade
     * @return entidade persistida
     */
    public T atualizar(T entidade) throws ExcecaoRepositorio;   
    
//    /**
//     * Retorna uma lista de entidades por situacao
//     * @param ordenarPor
//     * @return
//     */
//    public List<T> consultarPorSituacao(Boolean situacao, String ordenarPor) throws ExcecaoRepositorio;
//    
//    /**
//     * Retorna uma lista de entidades filtrando por campo
//     * @param ordenarPor
//     * @return
//     */
//    public List<T> consultarPorCampo(String campo, Object valor, String ordenarPor) throws ExcecaoRepositorio;
//    
//    /**
//     * Verifica Duplicidade
//     *
//     * @param id, descrico, mensagem
//     * @return
//     */
//    public void consultarPorDuplicidade(Integer id, String descricao, String mensagem) throws ExcecaoRepositorio;
//
//    /**
//     * Verifica Duplicidade ao Atualizar
//     *
//     * @param descricao
//     * @return boolean
//     */
//    public boolean validarDuplicidadeAoSalvar(String descricao);
//
//    /**
//     * Verifica Duplicidade ao Atualizar
//     *
//     * @param id, descricao
//     * @return boolean
//     */
//    public boolean validarDuplicidadeAoAtualizar(Integer id, String descricao);
}
