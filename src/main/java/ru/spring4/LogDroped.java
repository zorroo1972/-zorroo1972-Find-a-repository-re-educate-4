package ru.spring4;

import org.springframework.stereotype.Component;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class LogDroped {
    FileWriter writer = new FileWriter("C:\\Users\\zorro\\IdeaProjects\\re-educate-4\\src\\main\\resources\\Log\\log.txt");
    public LogDroped() throws IOException {
    }
    public void putIntoLog(String log) throws IOException {
        try {
            writer.write(log+"\n");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}


