package com.lesson.squares.Person.controller;

import com.lesson.squares.Person.service.PersonService;
import com.lesson.squares.crud.controller.CrudController;
import com.lesson.squares.Person.entity.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController extends CrudController<Person, String> {
    public PersonController(PersonService service) {
        super(service);
    }
}
