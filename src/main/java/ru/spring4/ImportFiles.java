package ru.spring4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.function.Consumer;

@Component
public class ImportFiles {
    @Value("${import}")
    private Resource importLocation;
    private static File folder = new File("C:\\Users\\zorro\\IdeaProjects\\re-educate-4\\src\\main\\resources\\Import");//"$(importLocation)");
    private File[] listOfFiles = folder.listFiles();
    public File[] getFiles(){
        return folder.listFiles();

    }

}
