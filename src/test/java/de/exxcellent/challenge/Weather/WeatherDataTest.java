package de.exxcellent.challenge.Weather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherDataTest {

    @Test
    void createsCorrectObjectFromDefaultConstructor() {
        WeatherData data = new WeatherData(1, 28, 20);

        assertEquals(1, data.getDay());
        assertEquals(28, data.getMaxTemp());
        assertEquals(20, data.getMinTemp());
    }

    @Test
    void createsCorrectObjectFromListConstructor() {
        String[] values = new String[]{
            "1", "20", "15"
        };

        WeatherData data = new WeatherData(values);

        assertEquals(1, data.getDay());
        assertEquals(20, data.getMaxTemp());
        assertEquals(15, data.getMinTemp());
    }

    @Test
    void calculatesCorrectTempSpread() {
        WeatherData data = new WeatherData(1, 25, 10);

        assertEquals(15, data.getTempSpread());
    }
}
