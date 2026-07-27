package de.exxcellent.challenge.Weather;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.InvalidLineException;

public class WeatherCsvFileReaderTest {

    final String SHARED_PATH = "src/test/java/de/exxcellent/challenge/resources/";

    final String TEST_FILE_PATH = SHARED_PATH + "testFile.csv";
    final String EMPTY_FILE_PATH = SHARED_PATH + "emptyFile.csv";
    final String NON_EXISTING_FILE_PATH = SHARED_PATH + "faultyFile.csv";
    final String INVALID_TEST_FILE_PATH = SHARED_PATH + "invalidTestFile.csv";

    @Test
    void readsFileContentCorrectly() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> testFileContent = new ArrayList<>();
        testFileContent.add(new WeatherData(1, 20, 15));
        testFileContent.add(new WeatherData(2, 18, 14));

        assertEquals(testFileContent, reader.parseFile());
    }

    @Test
    void readsEmptyFile() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(EMPTY_FILE_PATH);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void returnsEmptyListForNonExistingFile() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(NON_EXISTING_FILE_PATH);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void ignoresHeaderLine() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> result = reader.parseFile();

        assertEquals(2, result.size());
    }

    @Test
    void parseAllEntries() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> result = reader.parseFile();

        assertEquals(2, result.size());
    }

    @Test
    void throwsExceptionForInvalidLine() {
        WeatherCsvFileReader reader = new WeatherCsvFileReader(INVALID_TEST_FILE_PATH);

        InvalidLineException exception = assertThrows(
            InvalidLineException.class, () -> reader.parseFile()
        );

        assertEquals("Invalid line: 1,20,15", exception.getMessage());
    }
}
