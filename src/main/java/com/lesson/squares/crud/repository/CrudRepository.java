package com.lesson.squares.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends MongoRepository<T, ID> {
    List<T> findAll();
}
