package com.company.DAO;
import java.util.List;

public interface IDAO <T>{
    public T guardar(T t);
    public void eliminar(int id);
    public T buscar(int id);
    public List<T> buscarTodos();
}
