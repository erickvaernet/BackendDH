package com.example.integradorV2.Services;

import java.util.List;

public interface ICRUDService<T> {

    T save(T obj);
    T update(Long id,T obj);
    T findById(Long id);
    void deleteById(Long id);
    List<T> findAll();


}
