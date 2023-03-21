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

    @Override
    public String toString() {
        String str = "---------------------------------------------------\n";
        for (String[] row : getSquares()) {
            str += "|";
            for (String col : row) {
                if (col != null) {
                    str += String.format(" %s |", col);
                } else {
                    str += String.format(" %s |", "  ");
                }
            }
            str += "\n---------------------------------------------------\n";
        }

        return str;
    }
}
