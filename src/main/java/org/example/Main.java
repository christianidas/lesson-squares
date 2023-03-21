package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String COMMAND_MESSAGE = "Please enter a command";

    public static void main(String[] args) throws IOException {
        String[][] grid = new String[10][10];

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
                    addSquare(grid, rowToAdd, colToAdd, name);
                    break;
                case "remove":
                case "r":
                    int rowToRemove = Integer.parseInt(prompt("Row"));
                    int colToRemove = Integer.parseInt(prompt("Col"));
                    removeSquare(grid, rowToRemove, colToRemove);
                    break;
                default:
                    System.out.println("Invalid command!");
            }
        } while (true);
    }

    private static void printGrid(String[][] grid) {
        System.out.println("---------------------------------------------------");
        for (String[] row : grid) {
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

    private static void addSquare(String[][] grid, int row, int col, String name) {
        grid[row][col] = name;
    }

    private static void removeSquare(String[][] grid, int row, int col) {
        grid[row][col] = null;
    }

    private static String prompt(String message) throws IOException {
        System.out.printf("%s: ", message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}