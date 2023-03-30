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
    public Person get(@PathVariable int id) {
        return personService.get(id);
    }

    @PutMapping("/person/{id}")
    public Person update(@PathVariable int id, @RequestBody Person person) {
        return personService.update(id, person);
    }

    public void delete(int index) {
        personService.delete(index);
    }
}
