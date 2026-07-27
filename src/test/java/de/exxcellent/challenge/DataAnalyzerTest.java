package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

public class DataAnalyzerTest {

    @Test
    void returnsWeatherWithSmallestTempSpread() {
        DataAnalyzer analyzer = new DataAnalyzer("");

        ArrayList<WeatherData> data = new ArrayList<>();
        data.add(new WeatherData(1, 15, 10));
        data.add(new WeatherData(2, 8, 4));
        data.add(new WeatherData(3, 5, 4));

        WeatherData expected = new WeatherData(3, 5, 4);

        assertEquals(expected, analyzer.calculateSmallestTempSpread(data));
    }

    @Test
    void throwsExceptionForEmptyList() {
        DataAnalyzer analyzer = new DataAnalyzer("");

        ArrayList<WeatherData> emptyData = new ArrayList<>();

        assertThrows(NoSuchElementException.class, () -> analyzer.calculateSmallestTempSpread(emptyData));
    }

}
