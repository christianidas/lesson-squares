package org.example.Grid.repository;

import org.example.Grid.entity.Grid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GridRepository extends CrudRepository<Grid, Integer> {
    List<Grid> findAll();
}
