package de.exxcellent.challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void throwsExceptionForInvalidArgument() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, () -> App.main("--invalidArg")
        );

        assertTrue(exception.getMessage().equals("Unknown argument: --invalidArg"));
    }

}