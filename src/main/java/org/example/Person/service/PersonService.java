package org.example.Person.service;

import org.example.Person.entity.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private final String connectionUrl = "jdbc:mysql://localhost:3306/squares?serverTimezone=UTC";

    public Person create(Person person) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement ps = conn.prepareStatement(String.format("INSERT INTO person (name) VALUES('%s')", person.getName()));
            ps.executeUpdate();
            // This will return the last added person, so hopefully the insert worked
            PreparedStatement selectPersonStatement = conn.prepareStatement("SELECT * FROM person ORDER BY id DESC LIMIT 1");
            ResultSet selectPersonResult = selectPersonStatement.executeQuery();
            if (selectPersonResult.next()) {
                int id = selectPersonResult.getInt("id");
                person.setId(id);
                return person;
            }
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
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "squares", "squares");
            PreparedStatement selectPersonStatement = conn.prepareStatement(String.format("SELECT * FROM person WHERE id=%d", index));
            ResultSet selectPersonResult = selectPersonStatement.executeQuery();

            if (selectPersonResult.next()) {
                Person person = new Person();
                int id = selectPersonResult.getInt("id");
                person.setId(id);
                String name = selectPersonResult.getString("name");
                person.setName(name);
                return person;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
