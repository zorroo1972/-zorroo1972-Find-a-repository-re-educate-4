package ru.spring4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FioConverterTest {

    @Test
    @DisplayName("FioConverterTest")

    void testCheckFio() {
        Users users = new Users();
        users.fio = "Test Test";
        users.username = "test";
        Users result = FioConverter.checkFio(users);
        Assertions.assertEquals(users, result);
    }
}
