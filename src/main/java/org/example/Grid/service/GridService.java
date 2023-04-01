package org.example.Grid.service;

import org.example.Grid.entity.Grid;
import org.example.Grid.repository.GridRepository;
import org.example.crud.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class GridService extends CrudService<Grid, Integer> {
    public GridService(GridRepository repository) {
        super(repository);
    }
}
