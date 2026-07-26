package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherDataTest {

    @Test
    void createsCorrectObject() {
        WeatherData data = new WeatherData(1, 28, 20);

        assertEquals(1, data.day);
        assertEquals(28, data.maxTemp);
        assertEquals(20, data.minTemp);
    }
    
}
