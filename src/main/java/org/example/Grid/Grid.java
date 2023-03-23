package org.example.Grid;

import org.example.Person.Person;

public class Grid {
    private Square[][] squares;

    public Grid() {
        this(10, 10);
    }

    public Grid(int rows, int cols) {
        squares = new Square[rows][cols];
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] people) {
        this.squares = people;
    }

    public void addSquare(int row, int col, String name) {
        Square square = new Square();
        Person person = new Person();
        person.setName(name);
        square.setOwner(person);
        squares[row][col] = square;
    }

    public void removeSquare(int row, int col) {
        squares[row][col] = null;
    }

    @Override
    public String toString() {
        String str = " ";
        for (int i = 0; i < squares[0].length; i++) {
            str += "    " + i;
        }
        str += "\n   ";
        for (int i = 0; i < squares[0].length; i++) {
            str += "-----";
        }
        str += "-\n";
        for (int i = 0; i < squares.length; i++) {
            Square[] row = squares[i];
            str += i + "  |";
            for (Square col : row) {
                if (col != null) {
                    str += String.format(" %s |", col.getOwner().getInitials());
                } else {
                    str += String.format(" %s |", "  ");
                }
            }
            str += "\n   ";
            for (int j = 0; j < squares[0].length; j++) {
                str += "-----";
            }
            str += "-\n";
        }

        return str;
    }
}
