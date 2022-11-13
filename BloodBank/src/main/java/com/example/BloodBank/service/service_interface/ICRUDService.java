package com.example.BloodBank.service.service_interface;

public interface ICRUDService<T> {

    void Create(T entity) throws Exception;
    T Read(int id) throws Exception;
    void Update(T entity) throws Exception;
    void Delete(T entity) throws Exception;

    Iterable<T> GetAll() throws Exception;
}
