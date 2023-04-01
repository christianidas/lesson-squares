package org.example.crud.controller;

import org.example.crud.service.CrudService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class CrudController<T, ID> {
    private final CrudService<T, ID> service;

    public CrudController(CrudService<T, ID> service) {
        this.service = service;
    }

    @PostMapping("")
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @GetMapping("")
    public List<T> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public T get(@PathVariable ID id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}
