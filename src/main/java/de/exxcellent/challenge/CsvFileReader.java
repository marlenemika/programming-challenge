package de.exxcellent.challenge;

import java.io.*;
import java.util.*;

public class CsvFileReader {

    public String filePath;

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<WeatherData> parseFile() {
        ArrayList<WeatherData> parsedContent = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Day,MxT,MnT")) continue;
                parsedContent.add(parseLineToWeatherData(line));
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

}
