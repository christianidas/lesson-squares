package org.example.Person.service;

import org.example.Person.entity.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final List<Person> people = new ArrayList<>();

    public Person create(Person person) {
        people.add(person);
        return person;
    }

    public List<Person> getAll() {
        return people;
    }

    public Person get(int index) {
        return people.get(index);
    }

    public Person update(int index, Person person) {
        Person res = get(index);
        res.setName(person.getName());
        return res;
    }

    public void delete(int index) {
        people.remove(index);
    }
}
