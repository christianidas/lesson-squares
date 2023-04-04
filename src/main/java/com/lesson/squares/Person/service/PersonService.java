package com.lesson.squares.Person.service;

import com.lesson.squares.Person.entity.Person;
import com.lesson.squares.Person.repository.PersonRepository;
import com.lesson.squares.crud.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends CrudService<Person, Integer> {
    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
