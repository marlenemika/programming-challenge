package de.exxcellent.challenge;

import de.exxcellent.challenge.Football.FootballDataAnalyzer;
import de.exxcellent.challenge.Weather.WeatherDataAnalyzer;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    final static String WEATHER_FILE_PATH = "src/main/resources/de/exxcellent/challenge/weather.csv";
    final static String FOOTBALL_FILE_PATH = "src/main/resources/de/exxcellent/challenge/football.csv";

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        // Runs both challenges, no arguments passed/needed
        // run basic command, as pre-configured: mvn exec:java
        if (args.length == 0) {
            weatherChallenge();
            footballChallenge();
            return;
        }
        
        // Only runs the selected challenge, passed via argument "--weather" or "--football"
        // Throws an IllegalArgumentException for all other passed arguments than listed above
        switch (args[0].toLowerCase()) {
            // run: mvn exec:java -Dexec.args="--weather"
            case "--weather":
                weatherChallenge();
                break;

            // run: mvn exec:java -Dexec.args="--football"
            case "--football":
                footballChallenge();
                break;
            default:
                throw new IllegalArgumentException("Unknown argument: " + args[0]);
        }

    }

    // The weather challenge (Task 1)
    private static void weatherChallenge() {
        WeatherDataAnalyzer weatherDataAnalyzer = new WeatherDataAnalyzer(WEATHER_FILE_PATH);
        System.out.print("Day with smallest temperature spread: ");
        weatherDataAnalyzer.run();
    }

    // The football challenge (Task 2)
    private static void footballChallenge() {
        FootballDataAnalyzer footballDataAnalyzer = new FootballDataAnalyzer(FOOTBALL_FILE_PATH);
        System.out.printf("Team with smallest goal spread: ");
        footballDataAnalyzer.run();
    }
}
