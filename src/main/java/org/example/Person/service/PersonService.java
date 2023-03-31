package org.example.Person.service;

import org.example.Person.entity.Person;
import org.example.Person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final String connectionUrl = "jdbc:mysql://localhost:3306/squares?serverTimezone=UTC";

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
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            return optionalPerson.get();
        }

        return null;
    }

    public Person update(int index, Person person) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement updatePersonStatement = conn.prepareStatement(String.format("UPDATE person SET name='%s' WHERE id=%d", person.getName(), index));
            updatePersonStatement.executeUpdate();
            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(int index) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement deletePersonStatement = conn.prepareStatement(String.format("DELETE FROM person WHERE id=%d", index));
            deletePersonStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
