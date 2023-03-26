package org.example;

import org.example.Grid.entity.Grid;
import org.example.Grid.service.GridService;
import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) throws IOException {
        final GridService gridService = new GridService();
        final PersonService personService = new PersonService();

        do {
            String command = prompt(COMMAND_MESSAGE).toLowerCase();
            String[] parts = command.split(" ");

            if (parts.length < 2) {
                System.out.println("Invalid command!");
                continue;
            }

            String action = parts[0];
            String entity = parts[1];
            int index = 0;

            if (parts.length > 2) {
                index = Integer.parseInt(parts[2]);
            }

            if (command.equals("q")) {
                break;
            }

            switch (entity) {
                case "grid":
                    Grid grid;

                    switch (action) {
                        case "add":
                        case "a":
                            System.out.println(gridService.create(new Grid()));
                            break;
                        case "get":
                        case "g":
                            System.out.println(gridService.get(index));
                            break;
                        case "update":
                        case "u":
                            int row;
                            int col;
                            String updateAction = prompt("Add or remove a square?");
                            switch (updateAction) {
                                case "add":
                                case "a":
                                    int personIndex = Integer.parseInt(prompt("Who are we adding?"));
                                    Person person = personService.get(personIndex);
                                    row = Integer.parseInt(prompt("Row"));
                                    col = Integer.parseInt(prompt("Col"));
                                    grid = gridService.get(index);
                                    grid.getSquares().stream().filter(square -> square.getRow() == row && square.getCol() == col).findAny().ifPresent(square -> square.setOwner(person));
                                    System.out.println(gridService.update(index, grid));
                                    break;
                                case "remove":
                                case "r":
                                    grid = gridService.get(index);
                                    row = Integer.parseInt(prompt("Row"));
                                    col = Integer.parseInt(prompt("Col"));
                                    grid.getSquares().stream().filter(square -> square.getRow() == row && square.getCol() == col).findAny().ifPresent(square -> square.setOwner(null));
                                    break;
                                default:
                                    System.out.println("Invalid command!");
                            }
                            break;
                        case "remove":
                        case "r":
                            gridService.delete(index);
                            break;
                        default:
                            System.out.println("Invalid command!");
                    }
                    break;
                case "person":
                    Person person;
                    String name;
                    switch (action) {
                        case "add":
                        case "a":
                            person = new Person();
                            name = prompt("Name");
                            person.setName(name);
                            System.out.println(personService.create(person));
                            break;
                        case "get":
                        case "g":
                            System.out.println(personService.get(index));
                            break;
                        case "update":
                        case "u":
                            person = personService.get(index);
                            name = prompt("Name");
                            person.setName(name);
                            personService.update(index, person);
                            break;
                        case "remove":
                        case "r":
                            personService.delete(index);
                            break;
                        default:
                            System.out.println("Invalid command!");
                    }
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        } while (true);
    }

    private static String prompt(String message) throws IOException {
        System.out.printf("%s: ", message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}