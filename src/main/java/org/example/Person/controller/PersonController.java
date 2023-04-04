package org.example.Person.controller;

import org.example.Person.entity.Person;
import org.example.Person.service.PersonService;
import org.example.crud.controller.CrudController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController extends CrudController<Person, Integer> {
    public PersonController(PersonService service) {
        super(service);
    }
}
