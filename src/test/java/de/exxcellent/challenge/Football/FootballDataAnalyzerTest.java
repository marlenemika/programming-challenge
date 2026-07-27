package de.exxcellent.challenge.Football;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.Test;

public class FootballDataAnalyzerTest {

    @Test
    void returnsFootballWithSmallestGoalDifference() {
        FootballDataAnalyzer analyzer = new FootballDataAnalyzer("");

        ArrayList<FootballData> data = new ArrayList<>();
        data.add(new FootballData("Team_one", 25, 19));
        data.add(new FootballData("TEAM_TWO", 28, 15));
        data.add(new FootballData("third team", 12, 28));

        FootballData expected = new FootballData("Team_one", 25, 19);

        assertEquals(expected, analyzer.calculateSmallestGoalDifference(data));
    }

    @Test
    void throwsExceptionForEmptyList() {
        FootballDataAnalyzer analyzer = new FootballDataAnalyzer("");

        ArrayList<FootballData> emptyData = new ArrayList<>();

        assertThrows(NoSuchElementException.class, () -> analyzer.calculateSmallestGoalDifference(emptyData));
    }
    
}
