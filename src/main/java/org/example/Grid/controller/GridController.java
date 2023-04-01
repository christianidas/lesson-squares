package org.example.Grid.controller;

import org.example.Grid.entity.Grid;
import org.example.Grid.service.GridService;
import org.example.crud.controller.CrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grid")
public class GridController extends CrudController<Grid, Integer> {
    private final GridService service;

    public GridController(GridService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAsString(@PathVariable int id) {
        return service.get(id).toString();
    }

    @PutMapping("/{id}/shuffle")
    public Grid shuffle(@PathVariable int id) {
        Grid grid = service.get(id);
        grid.shuffle();
        return service.update(id, grid);
    }
}
