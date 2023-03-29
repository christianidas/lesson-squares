package org.example.Person.service;

import org.example.Person.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/squares?serverTimezone=UTC";
    private Integer id = 0;
    private final List<Person> people = new ArrayList<>();

    public Person create(Person person) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement ps = conn.prepareStatement(String.format("INSERT INTO person (name) VALUES('%s')", person.getName()));
            ps.executeUpdate();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Person> getAll() {
        List<Person> results = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement selectPersonStatement = conn.prepareStatement("SELECT * FROM person");
            ResultSet selectPersonResult = selectPersonStatement.executeQuery();

            while (selectPersonResult.next()) {
                Person person = new Person();
                int id = selectPersonResult.getInt("id");
                person.setId(id);
                String name = selectPersonResult.getString("name");
                person.setName(name);
                results.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
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
