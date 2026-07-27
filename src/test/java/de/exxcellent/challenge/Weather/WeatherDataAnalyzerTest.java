package de.exxcellent.challenge.Weather;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

public class WeatherDataAnalyzerTest {

    @Test
    void returnsWeatherWithSmallestTempSpread() {
        WeatherDataAnalyzer analyzer = new WeatherDataAnalyzer("");

        ArrayList<WeatherData> data = new ArrayList<>();
        data.add(new WeatherData(1, 15, 10));
        data.add(new WeatherData(2, 8, 4));
        data.add(new WeatherData(3, 5, 4));

        WeatherData expected = new WeatherData(3, 5, 4);

        assertEquals(expected, analyzer.calculateSmallestTempSpread(data));
    }

    @Test
    void throwsExceptionForEmptyList() {
        WeatherDataAnalyzer analyzer = new WeatherDataAnalyzer("");

        ArrayList<WeatherData> emptyData = new ArrayList<>();

        assertThrows(NoSuchElementException.class, () -> analyzer.calculateSmallestTempSpread(emptyData));
    }

}
