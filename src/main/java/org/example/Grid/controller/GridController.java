package org.example.Grid.controller;

import org.example.Grid.entity.Grid;
import org.example.Grid.service.GridService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grid")
public class GridController {
    private final GridService gridService;

    public GridController(GridService gridService) {
        this.gridService = gridService;
    }

    @PostMapping("")
    public Grid create(@RequestBody Grid grid) {
        return gridService.create(grid);
    }

    @GetMapping("")
    public List<Grid> getAll() {
        return gridService.getAll();
    }

    @GetMapping("/{id}")
    public Grid get(@PathVariable int id) {
        return gridService.get(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAsString(@PathVariable int id) {
        return gridService.get(id).toString();
    }

    @PutMapping("/{id}")
    public Grid update(@PathVariable int id, @RequestBody Grid grid) {
        return gridService.update(id, grid);
    }

    @PutMapping("/{id}/shuffle")
    public Grid shuffle(@PathVariable int id) {
        Grid grid = gridService.get(id);
        grid.shuffle();
        return gridService.update(id, grid);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        gridService.delete(id);
    }
}
