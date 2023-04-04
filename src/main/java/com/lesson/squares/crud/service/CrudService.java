package com.lesson.squares.crud.service;

import com.lesson.squares.crud.repository.CrudRepository;

import java.util.List;

public abstract class CrudService<T, ID> {
    private final CrudRepository<T, ID> repository;

    public CrudService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T get(ID id) {
        return repository.findById(id).orElse(null);
    }

    public T update(ID id, T entity) {
        return repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }
}
