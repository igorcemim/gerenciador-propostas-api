package br.com.gerenciadorproposta.service;

import java.util.List;

import br.com.gerenciadorproposta.exception.BusinessException;
import br.com.gerenciadorproposta.exception.EntityNotFoundException;

public interface CrudService<T, ID> {

    List<T> findAll();

    T findOne(ID id) throws EntityNotFoundException;

    void delete(ID id) throws EntityNotFoundException, BusinessException;

    T update(T cliente) throws EntityNotFoundException, BusinessException;

    T save(T cliente) throws EntityNotFoundException, BusinessException;

}