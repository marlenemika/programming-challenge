package de.exxcellent.challenge;

import java.io.*;
import java.util.*;

public class CsvFileReader {

    public String filePath;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> parseFile() {
        List<String> parsedContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parsedContent.add(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred:" + e);
            e.printStackTrace();
        }
        return parsedContent;
    }

}
