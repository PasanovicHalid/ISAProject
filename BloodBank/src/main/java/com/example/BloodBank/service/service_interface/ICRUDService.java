package com.example.BloodBank.service.service_interface;

public interface ICRUDService<T> {

    T Create(T entity) throws Exception;
    T Read(Long id) throws Exception;
    T Update(T entity) throws Exception;
    void Delete(T entity) throws Exception;

    Iterable<T> GetAll() throws Exception;
}
