package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] grid = new String[10][10];

        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                System.out.printf(" %s |", grid[i][j]);
            }
            System.out.print("\n");
        }
    }
}