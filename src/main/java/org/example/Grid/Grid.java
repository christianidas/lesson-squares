package org.example.Grid;

import org.example.Person.Person;

public class Grid {
    private Square[][] squares;

    public Grid() {
        this(10, 10);
    }

    public Grid(int rows, int cols) {
        squares = new Square[rows][cols];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                squares[i][j] = new Square();
            }
        }
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] people) {
        this.squares = people;
    }

    public void addSquare(int row, int col, String name) {
        Person person = new Person();
        person.setName(name);
        squares[row][col].setOwner(person);
    }

    public void removeSquare(int row, int col) {
        squares[row][col].setOwner(null);
    }

    private int getColCount() {
        return squares[0].length;
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
        for (int i = 0; i < squares.length; i++) {
            Square[] row = squares[i];
            str += i + "  |";
            for (Square col : row) {
                if (col.getOwner() != null) {
                    str += String.format(" %s |", col.getOwner().getInitials());
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
