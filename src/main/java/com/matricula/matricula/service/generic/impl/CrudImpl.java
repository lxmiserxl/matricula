package com.matricula.matricula.service.generic.impl;

import java.util.List;

import com.matricula.matricula.exception.NotFountException;
import com.matricula.matricula.repo.generic.IGenericRepo;
import com.matricula.matricula.service.generic.ICrud;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new NotFountException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new NotFountException("ID NOT FOUND: " + id));
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public void deleteById(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new NotFountException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }

}
