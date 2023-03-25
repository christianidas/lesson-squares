package org.example.Grid.entity;

import org.example.Person.entity.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Grid {
    private List<Square> squares;

    public Grid() {
        this(10, 10);
    }

    public Grid(int rows, int cols) {
        squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Square square = new Square();
                square.setRow(i);
                square.setCol(j);
                squares.add(square);
            }
        }
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    public void addSquare(int row, int col, String name) {
        Person person = new Person();
        person.setName(name);
        squares.stream().filter(square -> square.getRow() == row && square.getCol() == col).forEach(square -> square.setOwner(person));
    }

    public void removeSquare(int row, int col) {
        squares.stream().filter(square -> square.getRow() == row && square.getCol() == col).forEach(square -> square.setOwner(null));
    }

    private int getRowCount() {
        return squares.stream().map(Square::getCol).max(Comparator.comparingInt(a -> a)).orElse(0) + 1;
    }

    private int getColCount() {
        return squares.stream().map(Square::getRow).max(Comparator.comparingInt(a -> a)).orElse(0) + 1;
    }

    private Square getSquare(int row, int col) {
        return squares.stream().filter(s -> s.getRow() == row && s.getCol() == col).findAny().orElse(null);
    }

    @Override
    public String toString() {
        String str = " ";
        for (int i = 0; i < getColCount(); i++) {
            str += "    " + i;
        }
        str += "\n   ";
        for (int i = 0; i < getColCount(); i++) {
            str += "-----";
        }
        str += "-\n";
        for (int i = 0; i < getRowCount(); i++) {
            str += i + "  |";
            for (int j = 0; j < getColCount(); j++) {
                Square square = getSquare(i, j);
                if (square.getOwner() != null) {
                    str += String.format(" %s |", square.getOwner().getInitials());
                } else {
                    str += String.format(" %s |", "  ");
                }
            }
            str += "\n   ";
            for (int j = 0; j < getColCount(); j++) {
                str += "-----";
            }
            str += "-\n";
        }

        return str;
    }
}
