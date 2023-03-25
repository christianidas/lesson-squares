package org.example;

import org.example.Grid.entity.Grid;
import org.example.Grid.service.GridService;
import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) throws IOException {
        final GridService gridService = new GridService();
        final PersonService personService = new PersonService();

        do {
            String command = prompt(COMMAND_MESSAGE).toLowerCase();
            String[] parts = command.split(" ");
            String action = parts[0];
            String entity = parts[1];
            int index;

            if (command.equals("q")) {
                break;
            }

            switch (action) {
                case "add":
                case "a":
                    switch (entity) {
                        case "grid":
                            gridService.create(new Grid());
                            break;
                        case "person":
                            Person person = new Person();
                            String name = prompt("Name");
                            person.setName(name);
                            personService.create(person);
                            break;
                        default:
                            System.out.println("Invalid command!");
                    }
                    break;
                case "get":
                case "g":
                    index = Integer.parseInt(parts[2]);
                    switch (entity) {
                        case "grid":
                            Grid grid = gridService.get(index);
                            System.out.println(grid);
                            break;
                        case "person":
                            Person person = personService.get(index);
                            System.out.println(person);
                            break;
                        default:
                            System.out.println("Invalid command!");
                    }
                    break;
                case "remove":
                case "r":
                    index = Integer.parseInt(parts[2]);
                    switch (entity) {
                        case "grid":
                            gridService.delete(index);
                            break;
                        case "person":
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