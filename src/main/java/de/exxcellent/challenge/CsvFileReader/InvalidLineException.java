package de.exxcellent.challenge.CsvFileReader;

public class InvalidLineException extends RuntimeException {

    public InvalidLineException(String message) {
        super(message);
    }

}