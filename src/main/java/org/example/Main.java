package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] grid = new String[10][10];

        grid[0][0] = "CB";

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
}