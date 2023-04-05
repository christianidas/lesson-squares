package com.lesson.squares.Grid.service;

import com.lesson.squares.Grid.entity.Grid;
import com.lesson.squares.Grid.repository.GridRepository;
import com.lesson.squares.crud.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class GridService extends CrudService<Grid, String> {
    public GridService(GridRepository repository) {
        super(repository);
    }
}
