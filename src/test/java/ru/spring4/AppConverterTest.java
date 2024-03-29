package ru.spring4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppConverterTest {
    public AppConverterTest() {
    }

    @Test
    @DisplayName("AppConverterTest")
    void testCheckApp() {
        Logins logins =new Logins();
        logins.user_id = 1;
        logins.application = "web";
        logins.access_date = new Date();
        Logins result = AppConverter.checkApp(logins);
        Assertions.assertEquals(logins, result);
    }
}
