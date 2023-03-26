package org.example.Person.controller;

import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;

import java.io.IOException;
import java.util.List;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Person create() throws IOException {
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

    public Person update(int index) throws IOException {
        Person person = personService.get(index);
        String name = CommandLineInterface.prompt("Name");
        person.setName(name);
        return personService.update(index, person);
    }

    public void delete(int index) {
        personService.delete(index);
    }
}
