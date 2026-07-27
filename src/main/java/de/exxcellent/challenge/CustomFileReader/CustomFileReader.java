package de.exxcellent.challenge.CustomFileReader;

import java.util.ArrayList;

/**
 * Interface for different file readers that each supports a different file format
 * 
 * All readers must at least implement the parseFile function since this is the core function
 * 
 * CustomFileReader
 * @param <T> the type of objects produced by the concrete file reader
 */
public interface CustomFileReader<T> {

    /**
     * Reads the file passed and converts its content to a list of objects of type T
     * 
     * @return a list of parsed objects of type T
     * @throws Exception if the file cannot be read or its content is invalid
     */
    public ArrayList<T> parseFile() throws Exception;
    
}