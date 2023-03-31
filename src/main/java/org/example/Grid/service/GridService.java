package org.example.Grid.service;

import org.example.Grid.entity.Grid;
import org.example.Grid.repository.GridRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GridService {
    private final GridRepository gridRepository;

    public GridService(GridRepository gridRepository) {
        this.gridRepository = gridRepository;
    }

    public Grid create(Grid grid) {
        return gridRepository.save(grid);
    }

    public List<Grid> getAll() {
        return gridRepository.findAll();
    }

    public Grid get(int id) {
        return gridRepository.findById(id).orElse(null);
    }

    public Grid update(int id, Grid grid) {
        return gridRepository.save(grid);
    }

    public void delete(int id) {
        gridRepository.deleteById(id);
    }
}
