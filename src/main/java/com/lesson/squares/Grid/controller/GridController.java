package com.lesson.squares.Grid.controller;

import com.lesson.squares.Grid.entity.Grid;
import com.lesson.squares.Grid.service.GridService;
import com.lesson.squares.crud.controller.CrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grid")
@CrossOrigin
public class GridController extends CrudController<Grid, String> {
    private final GridService service;

    public GridController(GridService service) {
        super(service);
        this.service = service;
    }

    @GetMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getAsString(@PathVariable String id) {
        return service.get(id).toString();
    }

    @PutMapping("/{id}/shuffle")
    public Grid shuffle(@PathVariable String id) {
        Grid grid = service.get(id);
        grid.shuffle();
        return service.update(id, grid);
    }
}
