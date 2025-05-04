package com.example.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileHandler {

    Map<String, String> map = new HashMap<>();

    public static void write(String frage, String email) {
        try {
            FileWriter fw = new FileWriter("fragen.txt", true);
            fw.write("Frage:\n" + frage + "\n"+ "\nEmail: " + email + "\n");
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean valid(String name, String password) {
        try {
            Scanner sc = new Scanner(new File("nametrue.txt"));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                if (parts[0].equals(name) && parts[1].equals(password)) {return true;
                }

                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

        }
        return false;

    }
}
