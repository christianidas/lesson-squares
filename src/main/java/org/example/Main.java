package org.example;

import org.example.Grid.controller.GridController;
import org.example.Grid.service.GridService;
import org.example.Person.controller.PersonController;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) {
        final GridService gridService = new GridService();
        final PersonService personService = new PersonService();
        final GridController gridController = new GridController(gridService, personService);
        final PersonController personController = new PersonController(personService);

        do {
            String command = CommandLineInterface.prompt(COMMAND_MESSAGE).toLowerCase();

            if (command.equals("q")) {
                break;
            }

            String[] parts = command.split(" ");

            if (parts.length < 2) {
                CommandLineInterface.print("Invalid command!");
                continue;
            }

            String entity = parts[1];

            switch (entity) {
                case "grid":
                    try {
                        CommandLineInterface.print(gridController.handler(command));
                    } catch (Exception e) {
                        CommandLineInterface.print(e.getMessage());
                    }
                    break;
                case "person":
                    try {
                        CommandLineInterface.print(personController.handler(command));
                    } catch (Exception e) {
                        CommandLineInterface.print(e.getMessage());
                    }
                    break;
                default:
                    CommandLineInterface.print("Invalid command!");
            }
        } while (true);
    }
}