package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) throws IOException {
        Grid grid = new Grid();

        do {
            printGrid(grid);

            String command = prompt(COMMAND_MESSAGE).toLowerCase();

            if (command.equals("q")) {
                break;
            }

            switch (command) {
                case "add":
                case "a":
                    int rowToAdd = Integer.parseInt(prompt("Row"));
                    int colToAdd = Integer.parseInt(prompt("Col"));
                    String name = prompt("Name");
                    grid.addSquare(rowToAdd, colToAdd, name);
                    break;
                case "remove":
                case "r":
                    int rowToRemove = Integer.parseInt(prompt("Row"));
                    int colToRemove = Integer.parseInt(prompt("Col"));
                    grid.removeSquare(rowToRemove, colToRemove);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        } while (true);
    }

    private static void printGrid(Grid grid) {
        System.out.println("---------------------------------------------------");
        for (String[] row : grid.getSquares()) {
            System.out.print("|");
            for (String col : row) {
                if (col != null) {
                    System.out.printf(" %s |", col);
                } else {
                    System.out.printf(" %s |", "  ");
                }
            }
            System.out.print("\n---------------------------------------------------\n");
        }
    }

    private static String prompt(String message) throws IOException {
        System.out.printf("%s: ", message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}