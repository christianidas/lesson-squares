package org.example.Person.repository;

import org.example.Person.entity.Person;
import org.example.crud.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
