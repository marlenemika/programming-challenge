package de.exxcellent.challenge.Football;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import de.exxcellent.challenge.CustomFileReader.CsvFileReader.InvalidLineException;

public class FootballCsvFileReaderTest {

    final String SHARED_PATH = "src/test/java/de/exxcellent/challenge/resources/";

    final String TEST_FILE_PATH = SHARED_PATH + "testFileFootball.csv";
    final String EMPTY_FILE_PATH = SHARED_PATH + "emptyFile.csv";
    final String NON_EXISTING_FILE_PATH = SHARED_PATH + "faultyFile.csv";
    final String INVALID_TEST_FILE_PATH = SHARED_PATH + "invalidTestFileFootball.csv";
    
    @Test
    void readsFileContentCorrectly() {
        FootballCsvFileReader reader = new FootballCsvFileReader(TEST_FILE_PATH);

        ArrayList<FootballData> testFileContent = new ArrayList<>();
        testFileContent.add(new FootballData("Manchester", 20, 10));
        testFileContent.add(new FootballData("PSG__ ", 5, 42));

        assertEquals(testFileContent, reader.parseFile());
    }

    @Test
    void readsEmptyFile() {
        FootballCsvFileReader reader = new FootballCsvFileReader(EMPTY_FILE_PATH);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void returnsEmptyListForNonExistingFile() {
        FootballCsvFileReader reader = new FootballCsvFileReader(NON_EXISTING_FILE_PATH);

        assertTrue(reader.parseFile().isEmpty());
    }

    @Test
    void ignoresHeaderLine() {
        FootballCsvFileReader reader = new FootballCsvFileReader(TEST_FILE_PATH);

        ArrayList<FootballData> result = reader.parseFile();

        assertEquals(2, result.size());
    }

    @Test
    void parseAllEntries() {
        FootballCsvFileReader reader = new FootballCsvFileReader(TEST_FILE_PATH);

        ArrayList<FootballData> result = reader.parseFile();

        assertEquals(2, result.size());
    }

    @Test
    void throwsExceptionForInvalidLine() {
        FootballCsvFileReader reader = new FootballCsvFileReader(INVALID_TEST_FILE_PATH);

        InvalidLineException exception = assertThrows(
            InvalidLineException.class, () -> reader.parseFile()
        );

        assertEquals("Invalid line: Manchester,20,10", exception.getMessage());
    }
}