package com.example.demoacademia.service.Impl;

import com.example.demoacademia.exception.ModelNotFoundException;
import com.example.demoacademia.repository.IGenericRepo;
import com.example.demoacademia.service.ICRUD;

import java.lang.reflect.Method;
import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUD<T,ID> {

    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {

        Class<?> clazz= t.getClass();
        String Classname=clazz.getSimpleName();

        String methodName="setId"+Classname;
        Method setIdMethod = clazz.getMethod(methodName,id.getClass());
        setIdMethod.invoke(t,id);

        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+id));
        return getRepo().save(t);
    }

    @Override
    public List<T> finAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoundException("ID NOT FOUND: "+id));
        getRepo().deleteById(id);
    }
}
