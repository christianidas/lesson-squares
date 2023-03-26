package org.example.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineInterface {
    private final static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void print(Object object) {
        System.out.println(object);
    }

    public static String prompt(String message) {
        System.out.printf("%s: ", message);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            return prompt(message);
        }
    }
}
