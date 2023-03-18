package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] grid = new String[10][10];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf("Enter a name for row %d col %d: ", i, j);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                String name = bufferedReader.readLine();
                addSquare(grid, i, j, name);
            }
        }

        printGrid(grid);
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
}