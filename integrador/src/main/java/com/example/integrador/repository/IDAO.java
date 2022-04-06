package com.example.integrador.repository;

import java.util.List;

public interface IDAO <T> {

    public T create(T newObject);
    public T update(T objectToBeUpdated);
    public void delete(int id);
    public T get(int id);
    public List<T> list();

}
