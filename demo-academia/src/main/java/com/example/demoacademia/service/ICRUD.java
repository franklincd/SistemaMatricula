package com.example.demoacademia.service;

import com.example.demoacademia.model.Alumn;

import java.util.List;

public interface ICRUD<T,ID> {
    T save(T t)throws Exception;
    T update(ID id, T t) throws Exception;
    List<T> finAll() throws Exception;
    T findById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
