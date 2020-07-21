package com.example.TPXProj.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static String readFile(String filepath) {
        StringBuilder fileString = new StringBuilder();
        try {
            System.out.println(filepath);
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                fileString.append(scanner.nextLine());
            }

            return fileString.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found.");
            e.printStackTrace();
            return "File could not be found.";
        }
    }
}
