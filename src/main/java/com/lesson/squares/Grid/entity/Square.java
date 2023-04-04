package com.lesson.squares.Grid.entity;

import jakarta.persistence.*;
import com.lesson.squares.Person.entity.Person;

@Entity
public class Square {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private int row;
    private int col;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    public Square() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
