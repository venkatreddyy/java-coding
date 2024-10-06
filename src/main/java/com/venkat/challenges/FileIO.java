package com.venkat.challenges;

import java.io.*;

public class FileIO {
    public static void main(String[] args) {
        String filename = "test.txt";

        // Write to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Hello, world!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

