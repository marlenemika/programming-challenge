package de.exxcellent.challenge.Football;

import de.exxcellent.challenge.CustomFileReader.CsvFileReader.CsvFileReader;

/**
 * Concrete implementation for reading football.csv file and
 * parsing it into a list of FootballData objects
 * 
 * FootballCsvFileReader
 */
public class FootballCsvFileReader extends CsvFileReader<FootballData> {

    // RegEx fields for line validation
    private static final String teamName = "[A-Za-z_ \\']+";
    // Positive integer
    private static final String positiveNumber = "\\d+";

    private static final String remainingFields = "(?:," + positiveNumber + "){7}";

    // Compose pattern according to csv file layout
    private static final String pattern = teamName + remainingFields;

    public FootballCsvFileReader(String filePath) {
        super(filePath);
    }

    /**
     * Splits line on commas and creates an FootballData object with the data in it
     * Requirement: the column headers always have the exact same order for each weather.csv file
     * 
     * @param line the line containing the data which should be parsed into an object
     * @return FootballData object containing the information as stored in line
     */
    @Override
    protected FootballData parseLineToDataObject(String line) {
        String[] lineContent = line.split(",|\\n");
        return new FootballData(lineContent);
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
        String[] minArguments = new String[]{"Team", "Goals", "Goals Allowed"};
        for (String argument : minArguments) {
            containsNeededArguments = containsNeededArguments && line.contains(argument);
        }
        return containsNeededArguments;
    }

    /**
     * Checks if the line has exactly 8 values
     * The first entry is the team name (including letter characters, underscores, spaces and apostrophes)
     * The remaining 7 entries are all integers
     * The first 7 values are each followed by a comma to seperate them
     * The last value is not required to be followed by a comma
     * 
     * @param line the line to be checked
     * @return true if the line contains 8 values following that pattern
     */
    @Override
    protected boolean isValidLine(String line) {
        return line.matches(pattern);
    }
    
}
