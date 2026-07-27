package de.exxcellent.challenge.Football;

import  static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FootballDataTest {

    @Test
    void createsCorrectObjectFromDefaultConstructor() {
        FootballData data = new FootballData("Team1", 10, 5);

        assertEquals("Team1", data.getTeam());
        assertEquals(10, data.getGoalsScored());
        assertEquals(5, data.getGoalsAllowed());
    }

    @Test
    void createsCorrectObjectFromListConstructor() {
        String[] values = new String[]{
            "TeamName", "other", "values", "not", "relevant", "1", "3"
        };

        FootballData data = new FootballData(values);

        assertEquals("TeamName", data.getTeam());
        assertEquals(1, data.getGoalsScored());
        assertEquals(3, data.getGoalsAllowed());
    }

    @Test
    void calculatesCorrectGoalsDifference() {
        FootballData data = new FootballData("Team", 14, 10);

        assertEquals(4, data.getGoalsDifference());
    }
}