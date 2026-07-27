package de.exxcellent.challenge.Football;

import java.util.*;

public class FootballDataAnalyzer {

    public String filePath;

    public FootballDataAnalyzer(String filePath) {
        this.filePath = filePath;
    }

    public void run() {
        FootballCsvFileReader reader = new FootballCsvFileReader(filePath);

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
