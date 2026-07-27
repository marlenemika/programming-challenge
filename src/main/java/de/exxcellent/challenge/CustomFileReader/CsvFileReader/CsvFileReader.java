package de.exxcellent.challenge.CustomFileReader.CsvFileReader;

import java.io.*;
import java.util.*;

import de.exxcellent.challenge.CustomFileReader.CustomFileReader;

/**
 * Abstract class for reading a csv file
 * Parses file and returns a list of objects of provided type T
 * 
 * CsvFileReader
 * @param <T> type of the concrete object
 */
public abstract class CsvFileReader<T> implements CustomFileReader<T> {

    private final String FILE_PATH;

    public CsvFileReader(String filePath) {
        this.FILE_PATH = filePath;
    }

    /**
     * Parse the file passed in the constructor line by line and 
     * converts every valid line into a object of the concrete type T
     * 
     * @return list of all parsed objects
     * @throws InvalidLineException if a line was read which is neither
     *  - the header row
     *  - an empty line
     *  - a valid line (specified in isValidLine)
     */
    @Override
    public ArrayList<T> parseFile() {
        ArrayList<T> parsedContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidLine(line)) 
                    parsedContent.add(parseLineToDataObject(line));
                else if (isValidHeader(line))
                    continue;
                else if (line.isBlank())
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

    /**
     * Converts the content of a validated line into a object of type T
     * 
     * @param line the line containing the data for the object
     * @return the object T filled with the values of line
     */
    protected abstract T parseLineToDataObject(String line);

    /**
     * Checks if the line is a valid header row
     * 
     * @param line the line to be inspected
     * @return true if header is valid
     *         false if header is not valid
     */
    protected abstract boolean isValidHeader(String line);

    /**
     * Checks if the line is a valid data row
     * 
     * @param line the line to be inspected
     * @return true if line is valid
     *         false if line is not valid
     */
    protected abstract boolean isValidLine(String line);
    
}
