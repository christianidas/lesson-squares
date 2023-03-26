package org.example;

import org.example.Grid.controller.GridController;
import org.example.Grid.service.GridService;
import org.example.Person.controller.PersonController;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;

import java.io.IOException;

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) {
        final GridService gridService = new GridService();
        final PersonService personService = new PersonService();
        final GridController gridController = new GridController(gridService, personService);
        final PersonController personController = new PersonController(personService);

        do {
            String command = CommandLineInterface.prompt(COMMAND_MESSAGE).toLowerCase();
            String[] parts = command.split(" ");

            if (parts.length < 2) {
                CommandLineInterface.print("Invalid command!");
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
                    switch (action) {
                        case "add":
                        case "a":
                            CommandLineInterface.print(gridController.create());
                            break;
                        case "get":
                        case "g":
                            CommandLineInterface.print(gridController.get(index));
                            break;
                        case "update":
                        case "u":
                            CommandLineInterface.print(gridController.update(index));
                            break;
                        case "remove":
                        case "r":
                            gridController.delete(index);
                            break;
                        default:
                            CommandLineInterface.print("Invalid command!");
                    }
                    break;
                case "person":
                    switch (action) {
                        case "add":
                        case "a":
                            CommandLineInterface.print(personController.create());
                            break;
                        case "get":
                        case "g":
                            CommandLineInterface.print(personController.get(index));
                            break;
                        case "update":
                        case "u":
                            CommandLineInterface.print(personController.update(index));
                            break;
                        case "remove":
                        case "r":
                            personService.delete(index);
                            break;
                        default:
                            CommandLineInterface.print("Invalid command!");
                    }
                    break;
                default:
                    CommandLineInterface.print("Invalid command!");
            }
        } while (true);
    }
}