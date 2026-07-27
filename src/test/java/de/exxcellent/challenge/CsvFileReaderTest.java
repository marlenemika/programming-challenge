package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CsvFileReaderTest {

    final String TEST_FILE_PATH = "src/test/java/de/exxcellent/challenge/resources/testFile.csv";

    @Test
    void readsFileContentCorrectly() {
        CsvFileReader reader = new CsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> testFileContent = new ArrayList<>();
        testFileContent.add(new WeatherData(1, 15, 20));
        testFileContent.add(new WeatherData(2, 14, 18));

        assertEquals(testFileContent, reader.parseFile());
    }

    @Test
    void readsEmptyFile() {
        String emptyFilePath = "src/test/java/de/exxcellent/challenge/resources/emptyFile.csv";

        CsvFileReader reader = new CsvFileReader(emptyFilePath);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void returnsEmptyListForInvalidFile() {
        String faultyFilePath = "src/test/java/de/exxcellent/challenge/faultyFile.csv";

        CsvFileReader reader = new CsvFileReader(faultyFilePath);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void ignoresHeaderLine() {
        CsvFileReader reader = new CsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> result = reader.parseFile();

        assertEquals(2, result.size());
    }

    @Test
    void parseAllEntries() {
        CsvFileReader reader = new CsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> result = reader.parseFile();

        assertEquals(2, result.size());
    }
}
