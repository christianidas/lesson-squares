package org.example;

class Grid {
    private String[][] squares = new String[10][10];

    public Grid() {

    }

    public String[][] getSquares() {
        return squares;
    }

    public void setSquares(String[][] squares) {
        this.squares = squares;
    }

    public void addSquare(int row, int col, String name) {
        squares[row][col] = name;
    }

    public void removeSquare(int row, int col) {
        squares[row][col] = null;
    }
}
