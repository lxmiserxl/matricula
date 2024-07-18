package com.matricula.matricula.service.generic;

import java.util.List;

public interface ICrud<T, ID> {
    T save(T t) throws Exception;

    T update(T t, ID id) throws Exception;

    T findById(ID id) throws Exception;

    List<T> findAll() throws Exception;

    void deleteById(ID id) throws Exception;

}
