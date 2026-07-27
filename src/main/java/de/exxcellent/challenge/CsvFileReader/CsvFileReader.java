package de.exxcellent.challenge.CsvFileReader;

import java.io.*;
import java.util.*;

public abstract class CsvFileReader<T> {

    public final String filePath;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<T> parseFile() {
        ArrayList<T> parsedContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidLine(line)) 
                    parsedContent.add(parseLineToDataObject(line));
                else if (isValidHeader(line))
                    continue;
                else
                    throw new InvalidLineException("Invalid line: " + line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
            e.printStackTrace();
        }
        return parsedContent;
    }

    protected abstract T parseLineToDataObject(String line);

    protected abstract boolean isValidHeader(String line);

    protected abstract boolean isValidLine(String line);
    
}
