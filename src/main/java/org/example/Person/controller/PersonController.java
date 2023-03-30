package org.example.Person.controller;

import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;
import org.example.util.CommandLineInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private final PersonService personService = new PersonService();

    @PostMapping("/person")
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @GetMapping("/person")
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/person/{id}")
    public Person get(@PathVariable("id") int index) {
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
