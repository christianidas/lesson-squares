package com.lesson.squares.Grid.entity;

import com.lesson.squares.Person.entity.Person;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Square {
    private int row;
    private int col;
    @DBRef
    private Person owner;

    public Square() {

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
