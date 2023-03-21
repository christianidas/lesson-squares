package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.print(grid);
    }

    private static String prompt(String message) throws IOException {
        System.out.printf("%s: ", message);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}