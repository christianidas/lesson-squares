package com.lesson.squares.crud.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends org.springframework.data.repository.CrudRepository<T, ID> {
    List<T> findAll();
}
