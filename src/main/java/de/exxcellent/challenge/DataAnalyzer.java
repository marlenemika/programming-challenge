package de.exxcellent.challenge;

import java.util.*;


public class DataAnalyzer {

    public String filePath;

    public DataAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        CsvFileReader reader = new CsvFileReader(filePath);

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
