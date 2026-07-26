package de.exxcellent.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CsvFileReaderTest {

    @Test
    void readsFileContentCorrectly() {
        String testFilePath = "src/test/java/de/exxcellent/challenge/resources/testFile.csv";

        CsvFileReader reader = new CsvFileReader(testFilePath);

        List<String> testFileContent = List.of(
            "car,hp,vmax",
            "1,90,160",
            "2,150,200",
            "3,500,300"
        );

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
}
