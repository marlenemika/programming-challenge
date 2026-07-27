package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class CsvFileReaderTest {

    final String SHARED_PATH = "src/test/java/de/exxcellent/challenge/resources/";

    final String TEST_FILE_PATH = SHARED_PATH + "testFile.csv";
    final String EMPTY_FILE_PATH = SHARED_PATH + "emptyFile.csv";
    final String NON_EXISTING_FILE_PATH = SHARED_PATH + "faultyFile.csv";
    final String INVALID_TEST_FILE_PATH = SHARED_PATH + "invalidTestFile.csv";

    @Test
    void readsFileContentCorrectly() {
        CsvFileReader reader = new CsvFileReader(TEST_FILE_PATH);

        ArrayList<WeatherData> testFileContent = new ArrayList<>();
        testFileContent.add(new WeatherData(1, 20, 15));
        testFileContent.add(new WeatherData(2, 18, 14));

        assertEquals(testFileContent, reader.parseFile());
    }

    @Test
    void readsEmptyFile() {
        CsvFileReader reader = new CsvFileReader(EMPTY_FILE_PATH);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void returnsEmptyListForNonExistingFile() {
        CsvFileReader reader = new CsvFileReader(NON_EXISTING_FILE_PATH);

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

    @Test
    void throwsExceptionForInvalidLine() {
        CsvFileReader reader = new CsvFileReader(INVALID_TEST_FILE_PATH);

        InvalidLineException exception = assertThrows(
            InvalidLineException.class, () -> reader.parseFile()
        );

        assertEquals("Invalid line: 1,20,15", exception.getMessage());
    }
}
