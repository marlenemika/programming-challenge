package de.exxcellent.challenge.Weather;

import de.exxcellent.challenge.CustomFileReader.CsvFileReader.CsvFileReader;

/**
 * Concrete implementation for reading weather.csv file and
 * parsing it into a list of WeatherData objects
 * 
 * WeatherCsvFileReader
 */
public class WeatherCsvFileReader extends CsvFileReader<WeatherData> {

    public WeatherCsvFileReader(String filePath) {
        super(filePath);
    }

    /**
     * Splits line on commas and creates an WeatherData object with the data in it
     * Requirement: the column headers always have the exact same order for each football.csv file
     * 
     * @param line the line containing the data which should be parsed into an object
     * @return WeatherData object containing the information as stored in line
     */
    @Override
    protected WeatherData parseLineToDataObject(String line) {
        String[] lineContent = line.split(",|\\n");
        return new WeatherData(lineContent);
    }

    /**
     * Checks if the line contains the required column names to continue
     * Can be extended if more data should be analyzed by adding the wanted arguments
     * 
     * @param line the line to be checked
     * @return true if the line contains all column names required, else false
     */
    @Override
    protected boolean isValidHeader(String line) {
        boolean containsNeededArguments = true;
        String[] minArguments = new String[]{"Day", "MxT", "MnT"};
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
    @Override
    protected boolean isValidLine(String line) {
        String day = "\\d+";
        // Positive integer or decimal number
        String positiveNumber = "\\d+(?:\\.\\d+)?";
        // Negative integer or decimal number
        String negativeNumber = "-" + positiveNumber;

        // Temperatures may be below zero
        String temperatureFields = "(?:(?:" + positiveNumber + "|" + negativeNumber + "),){4}";

        // Remaining fields are never below zero
        String remainingFields = "(?:" + positiveNumber + ",){8}";

        // Compose pattern according to csv file layout
        String pattern = day + "," + temperatureFields + remainingFields + positiveNumber;

        return line.matches(pattern);
    }

}
