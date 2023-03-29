package org.example.Grid.service;

import org.example.Grid.entity.Grid;

import java.util.ArrayList;
import java.util.List;

public class GridService {
    private Integer id = 0;
    private final List<Grid> grids = new ArrayList<>();

    public Grid create(Grid grid) {
        grid.setId(id);
        id++;
        grids.add(grid);
        return grid;
    }

    public List<Grid> getAll() {
        return grids;
    }

    public Grid get(int index) {
        return grids.get(index);
    }

    public Grid update(int index, Grid grid) {
        Grid res = get(index);
        res.setSquares(grid.getSquares());
        return res;
    }

    public void delete(int index) {
        grids.remove(index);
    }
}
