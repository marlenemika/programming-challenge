package de.exxcellent.challenge.Weather;

import de.exxcellent.challenge.CsvFileReader.CsvFileReader;

public class WeatherCsvFileReader extends CsvFileReader<WeatherData> {

    public WeatherCsvFileReader(String filePath) {
        super(filePath);
    }

    @Override
    protected WeatherData parseLineToDataObject(String line) {
        String[] lineContent = line.split(",|\\n");
        return new WeatherData(lineContent);
    }

    /**
     * Checks if the line contains the required column names to continue
     * 
     * @param line the line to be checked
     * @return true if the line contains all column names required, else false
     */
    @Override
    protected boolean isValidHeader(String line) {
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
    @Override
    protected boolean isValidLine(String line) {
        return line.matches("(?:\\d+(?:\\.\\d+)?,){13}\\d+(?:\\.\\d+)?");
    }

}
