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

            if (parts.length < 2) {
                System.out.println("Invalid command!");
                continue;
            }

            String action = parts[0];
            String entity = parts[1];

            if (command.equals("q")) {
                break;
            }

            switch (entity) {
                case "grid":
                    switch (action) {
                        case "add":
                        case "a":
                            System.out.println(gridService.create(new Grid()));
                            break;
                        case "get":
                        case "g":
                            System.out.println(gridService.get(Integer.parseInt(parts[2])));
                            break;
                        case "remove":
                        case "r":
                            gridService.delete(Integer.parseInt(parts[2]));
                            break;
                        default:
                            System.out.println("Invalid command!");
                    }
                    break;
                case "person":
                    switch (action) {
                        case "add":
                        case "a":
                            Person person = new Person();
                            String name = prompt("Name");
                            person.setName(name);
                            System.out.println(personService.create(person));
                            break;
                        case "get":
                        case "g":
                            System.out.println(personService.get(Integer.parseInt(parts[2])));
                            break;
                        case "remove":
                        case "r":
                            personService.delete(Integer.parseInt(parts[2]));
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