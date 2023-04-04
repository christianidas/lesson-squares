package com.lesson.squares.Person.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

    public Person() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        String[] parts = name.toUpperCase().split(" ");
        if (parts.length > 1) {
            return parts[0].substring(0, 1) + parts[1].substring(0, 1);
        } else {
            return parts[0].substring(0, 2);
        }
    }

    @Override
    public String toString() {
        String str = "{";
        str += " id: " + getId() + ",";
        str +=  " name: " + getName() + ",";
        str += " initials: " + getInitials() + "";
        return str + " }";
    }
}
