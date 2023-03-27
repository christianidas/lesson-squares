package org.example.Person.controller;

import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;

import java.util.List;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Object handler(String command) throws Exception {
        String[] parts = command.split(" ");

        if (parts.length < 2) {
            throw new Exception("Invalid command!");
        }

        String action = parts[0];
        Integer index = null;
        if (parts.length > 2) {
            index = Integer.parseInt(parts[2]);
        }

        switch (action) {
            case "add":
            case "a":
                return create();
            case "get":
            case "g":
                if (index != null) {
                    return get(index);
                } else {
                    return getAll();
                }
            case "update":
            case "u":
                if (index != null) {
                    return update(index);
                } else {
                    throw new Exception("Invalid command!");
                }
            case "remove":
            case "r":
                if (index != null) {
                    delete(index);
                } else {
                    throw new Exception("Invalid command!");
                }
                return null;
            default:
                throw new Exception("Invalid command!");
        }
    }

    public Person create() {
        Person person = new Person();
        String name = CommandLineInterface.prompt("Name");
        person.setName(name);
        return personService.create(person);
    }

    public List<Person> getAll() {
        return personService.getAll();
    }

    public Person get(int index) {
        return personService.get(index);
    }

    public Person update(int index) {
        Person person = personService.get(index);
        String name = CommandLineInterface.prompt("Name");
        person.setName(name);
        return personService.update(index, person);
    }

    public void delete(int index) {
        personService.delete(index);
    }
}
