package org.example.Grid.controller;

import org.example.Grid.entity.Grid;
import org.example.Grid.service.GridService;
import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;

import java.util.List;

public class GridController {
    private final GridService gridService;
    private final PersonService personService;

    public GridController(GridService gridService, PersonService personService) {
        this.gridService = gridService;
        this.personService = personService;
    }

    public Grid create() {
        Grid grid = new Grid();
        return gridService.create(grid);
    }

    public List<Grid> getAll() {
        return gridService.getAll();
    }

    public Grid get(int index) {
        return gridService.get(index);
    }

    public Grid update(int index) {
        Grid grid;
        int row;
        int col;
        String action = CommandLineInterface.prompt("Add or remove a square?");
        switch (action) {
            case "add":
            case "a":
                int personIndex = Integer.parseInt(CommandLineInterface.prompt("Who are we adding?"));
                Person person = personService.get(personIndex);
                row = Integer.parseInt(CommandLineInterface.prompt("Row"));
                col = Integer.parseInt(CommandLineInterface.prompt("Col"));
                grid = gridService.get(index);
                grid.getSquares().stream().filter(square -> square.getRow() == row && square.getCol() == col).findAny().ifPresent(square -> square.setOwner(person));
                return gridService.update(index, grid);
            case "remove":
            case "r":
                grid = gridService.get(index);
                row = Integer.parseInt(CommandLineInterface.prompt("Row"));
                col = Integer.parseInt(CommandLineInterface.prompt("Col"));
                grid.getSquares().stream().filter(square -> square.getRow() == row && square.getCol() == col).findAny().ifPresent(square -> square.setOwner(null));
                return gridService.update(index, grid);
            default:
                CommandLineInterface.print("Invalid command!");
                return update(index);
        }
    }

    public void delete(int index) {
        gridService.delete(index);
    }
}
