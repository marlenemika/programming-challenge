package de.exxcellent.challenge;

import java.util.List;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    final static String WEATHER_FILE_PATH = "src/main/resources/de/exxcellent/challenge/weather.csv";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        DataAnalyzer dataAnalyzer = new DataAnalyzer(WEATHER_FILE_PATH);
        System.out.print("Day with smallest temperature spread: ");
        dataAnalyzer.run();

        /*
        String teamWithSmallestGoalSpread = "A good team"; // Your goal analysis function call …
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        */
    }
}
