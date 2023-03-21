package org.example;

class Grid {
    private Person[][] squares = new Person[10][10];

    public Grid() {

    }

    public Person[][] getSquares() {
        return squares;
    }

    public void setSquares(Person[][] people) {
        this.squares = people;
    }

    public void addSquare(int row, int col, String name, String initials) {
        Person person = new Person();
        person.setName(name);
        person.setInitials(initials);
        squares[row][col] = person;
    }

    public void removeSquare(int row, int col) {
        squares[row][col] = null;
    }

    @Override
    public String toString() {
        String str = "---------------------------------------------------\n";
        for (Person[] row : getSquares()) {
            str += "|";
            for (Person col : row) {
                if (col != null) {
                    str += String.format(" %s |", col.getInitials());
                } else {
                    str += String.format(" %s |", "  ");
                }
            }
            str += "\n---------------------------------------------------\n";
        }

        return str;
    }
}
