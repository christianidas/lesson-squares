package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] grid = new String[10][10];

        addSquare(grid, 0, 0, "CB");
        addSquare(grid, 3, 5, "CB");

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