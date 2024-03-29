package ru.spring4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class DateConverterTest {
    @Mock
    LogDroped logDroped;
    @InjectMocks
    DateConverter dateConverter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("DateConverterTest")
    void testCheck() throws IOException {

        dateConverter.string = "Test";
        boolean result = dateConverter.check("log");
        Assertions.assertEquals(true, result);
    }
}
