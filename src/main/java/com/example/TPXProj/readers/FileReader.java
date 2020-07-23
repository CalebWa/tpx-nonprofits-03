package com.example.TPXProj.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Read and deliver files. Take care of errors as smoothly as possible.
 *
 * @author Caleb Warner
 */
public class FileReader {
    // *************************************************************************
    // Fields
    // *************************************************************************
    /**
     * Reference to the database object that communicates with the ClearDB MySQL Database
     */
    private String fileNotFoundPath = "src/main/webapp/file-not-found.html";
    // *************************************************************************
    // Public Methods
    // *************************************************************************
    public static String readFile(String filepath) {
        StringBuilder fileString = new StringBuilder();
        try {
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
