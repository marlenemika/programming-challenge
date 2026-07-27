package de.exxcellent.challenge.Football;

import java.util.*;

public class FootballDataAnalyzer {

    private final String FILE_PATH;

    public FootballDataAnalyzer(String filePath) {
        this.FILE_PATH = filePath;
    }

    public void run() {
        FootballCsvFileReader reader = new FootballCsvFileReader(FILE_PATH);

        ArrayList<FootballData> parsedContent = reader.parseFile();

        if (!parsedContent.isEmpty())
            System.out.println(calculateSmallestGoalDifference(parsedContent).toString());
        else
            throw new NoSuchElementException("No football data found!");
    }
    
    public FootballData calculateSmallestGoalDifference(ArrayList<FootballData> data) {
        return Collections.min(data, Comparator.comparing(fD -> fD.getGoalsDifference()));
    }
    
}
