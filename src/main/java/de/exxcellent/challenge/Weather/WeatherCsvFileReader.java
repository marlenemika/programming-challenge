package de.exxcellent.challenge.Weather;

import java.io.*;
import java.util.*;

import de.exxcellent.challenge.CsvFileReader.InvalidLineException;

public class WeatherCsvFileReader {

    public String filePath;

    public WeatherCsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<WeatherData> parseFile() throws InvalidLineException {
        ArrayList<WeatherData> parsedContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidLine(line))
                    parsedContent.add(parseLineToWeatherData(line));
                else if (isValidHeader(line)) 
                    continue;
                else 
                    throw new InvalidLineException("Invalid line: " + line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred:" + e);
            e.printStackTrace();
        }
        return parsedContent;
    }

    private WeatherData parseLineToWeatherData(String line) {
        String[] lineContent = line.split(",|\\n");
        return new WeatherData(lineContent);
    }

    /**
     * Checks if the line contains the required column names to continue
     * 
     * @param line the line to be checked
     * @return true if the line contains all column names required, else false
     */
    private boolean isValidHeader(String line) {
        boolean containsNeededArguments = true;
        String[] minArguments = new String[] {"Day", "MxT", "MnT"};
        for (String argument : minArguments) {
            containsNeededArguments = containsNeededArguments && line.contains(argument);
        }
        return containsNeededArguments;
    }

    /**
     * Checks if the line has exactly 14 values that are either integers or decimal numbers
     * The first 13 values are each followed by a comma to separate them
     * The last value is not required to be followed by a comma
     * 
     * @param line the line to be checked
     * @return true if the line contains 14 values following that pattern
     */
    private boolean isValidLine(String line) {
        return line.matches("(?:\\d+(?:\\.\\d+)?,){13}\\d+(?:\\.\\d+)?");
    }

}
