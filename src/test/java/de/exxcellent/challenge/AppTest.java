package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void throwsExceptionForInvalidArgument() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> App.main("--invalidArg")
        );

        assertEquals("Unknown argument: --invalidArg", exception.getMessage());
    }

    @Test
    void runsOnlyWeatherChallenge() {
        assertDoesNotThrow(() -> App.main("--weather"));
    }

    @Test
    void runsOnlyFootballChallenge() {
        assertDoesNotThrow(() -> App.main("--football"));
    }

    @Test
    void argumentIsCaseInsensitive() {
        assertDoesNotThrow(() -> App.main("--WEATHER"));
    }

    @Test
    void runsBothChallengesWithNoArguments() {
        assertDoesNotThrow(() -> App.main());
    }
}