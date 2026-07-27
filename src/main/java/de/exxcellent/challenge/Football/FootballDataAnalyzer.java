package de.exxcellent.challenge.Football;

import java.util.*;

/**
 * Takes a list of FootballData objects and analyzes it for insights
 * Can be extended for several use cases (e.g. get LargestGoalDifference across all objects)
 * 
 * WeatherDataAnalyzer
 */
public class FootballDataAnalyzer {

    private final String FILE_PATH;

    public FootballDataAnalyzer(String filePath) {
        this.FILE_PATH = filePath;
    }

    /**
     * Analyzes the data for insights (i.e. smallest goal difference across all entries)
     * 
     * @throws NoSuchElementException if no FootballData objects exist
     */
    public void run() {
        FootballCsvFileReader reader = new FootballCsvFileReader(FILE_PATH);

        ArrayList<FootballData> parsedContent = reader.parseFile();

        if (!parsedContent.isEmpty())
            System.out.println(calculateSmallestGoalDifference(parsedContent).toString());
        else
            throw new NoSuchElementException("No football data found!");
    }
    
    /**
     * Calculates the smallest goal difference of a list of FootballData objects
     * 
     * @param data the data to be analysed
     * @return the FootballData object with the smallest goal difference of all passed ones
     */
    public FootballData calculateSmallestGoalDifference(ArrayList<FootballData> data) {
        return Collections.min(data, Comparator.comparing(fD -> fD.getGoalsDifference()));
    }
    
}
