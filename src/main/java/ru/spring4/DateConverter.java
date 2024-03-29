package ru.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.LogTransformation;

import java.io.IOException;

@LogTransformation
@Component
public class DateConverter {
    String string;
    @Autowired
    LogDroped logDroped;

    public DateConverter() {
    }
    boolean check(String log) throws IOException {
        if (this.string.isBlank()){
            logDroped.putIntoLog(log);
            return false;
        }
        return true;
    }
}
