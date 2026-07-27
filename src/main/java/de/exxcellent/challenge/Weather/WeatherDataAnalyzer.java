package de.exxcellent.challenge.Weather;

import java.util.*;


public class WeatherDataAnalyzer {

    private final String FILE_PATH;

    public WeatherDataAnalyzer(String filePath) {
        this.FILE_PATH = filePath;
    }

    public void run() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(FILE_PATH);

        ArrayList<WeatherData> parsedContent = reader.parseFile();

        if (!parsedContent.isEmpty())
            System.out.println(calculateSmallestTempSpread(parsedContent).toString());
        else
            throw new NoSuchElementException("No weather data found!");
    }

    /**
     * Calculates the smallest temperature spread of a list of WeatherData objects
     * 
     * @param data the data to be analysed
     * @return the WeatherData object with the smallest temparature spread of all passed ones
     */
    public WeatherData calculateSmallestTempSpread(ArrayList<WeatherData> data) {
        return Collections.min(data, Comparator.comparing(wD -> wD.getTempSpread()));
    }
}
