package com.lesson.squares.Person.entity;

import org.springframework.data.annotation.Id;

public class Person {
    @Id
    private String id;
    private String name;

    public Person() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
