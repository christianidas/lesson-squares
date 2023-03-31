package org.example.Person.service;

import org.example.Person.entity.Person;
import org.example.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person get(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person update(int id, Person person) {
        return personRepository.save(person);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
