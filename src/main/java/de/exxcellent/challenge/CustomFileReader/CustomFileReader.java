package de.exxcellent.challenge.CustomFileReader;

import java.util.List;

/**
 * Interface for different file readers that each supports a different file format
 * 
 * All readers must at least implement the parseFile function since this is the core function
 * 
 * CustomFileReader
 * @param <T> the type of objects produced by the concrete file reader
 */
public interface CustomFileReader<T> {

    public List<T> parseFile() throws Exception;
    
}