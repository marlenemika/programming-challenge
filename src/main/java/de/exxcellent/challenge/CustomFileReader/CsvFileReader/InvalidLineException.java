package de.exxcellent.challenge.CustomFileReader.CsvFileReader;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String message) {
        super(message);
    }

}