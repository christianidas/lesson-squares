package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] grid = new String[10][10];

        printGrid(grid);

        String command = prompt("Please enter a command");

        while (!command.equalsIgnoreCase("q")) {
            if (command.equalsIgnoreCase("add")) {
                int row = Integer.parseInt(prompt("Row"));
                int col = Integer.parseInt(prompt("Col"));
                String name = prompt("Name");
                addSquare(grid, row, col, name);
            }

            printGrid(grid);
            command = prompt("Please enter a command");
        }
    }

    private static void printGrid(String[][] grid) {
        for (String[] row : grid) {
            System.out.print("| ");
            for (String col : row) {
                System.out.printf(" %s |", col);
            }
            System.out.print("\n");
        }
    }

    private static void addSquare(String[][] grid, int row, int col, String name) {
        grid[row][col] = name;
    }

    private static String prompt(String message) throws IOException {
        System.out.printf("%s: ", message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}