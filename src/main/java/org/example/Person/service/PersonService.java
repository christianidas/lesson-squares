package org.example.Person.service;

import org.example.Person.entity.Person;
import org.example.Person.repository.PersonRepository;
import org.example.crud.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends CrudService<Person, Integer> {
    public PersonService(PersonRepository repository) {
        super(repository);
    }
}
