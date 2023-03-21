package org.example;

public class Person {
    private String name;

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitials() {
        return name.toUpperCase().substring(0, 2);
    }
}
