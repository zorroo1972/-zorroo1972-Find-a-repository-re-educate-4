package ru.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;
@LogTransformation
@Component
public class FileReader {
    File folder = new File("C:\\Users\\zorro\\IdeaProjects\\re-educate-4\\src\\main\\resources\\Import");
    File[] listOfFiles = folder.listFiles();
    Scanner sc;
    @Autowired Consumer<ModelTitle> builderdb;
    @Autowired Consumer<ModelBody> fillerdb;
    public void getFiles(){
        for (File file : listOfFiles) {
            if (file.isFile()) {
                ModelTitle modelTitle = new ModelTitle();
                modelTitle = getTitle(file);
                builderdb.accept(modelTitle);
                try {
                    sc = new Scanner(file);
                    sc.nextLine();
                    long i = 1;
                    while (sc.hasNextLine()) {
                        ModelBody modelBody = new ModelBody();
                        modelBody.source = sc.nextLine();
                        modelBody.name = file.getName();
                        modelBody.id = i++;
                        fillerdb.accept(modelBody);
                    }
                }
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                finally {sc.close();}
            }
        }
    }
    private ModelTitle getTitle(File file) {
        ModelTitle modelTitle = new ModelTitle();
        try {
            Scanner   sc = new Scanner(file);
            modelTitle.source = String.valueOf(sc.nextLine());
            modelTitle.name = file.getName();
            sc.close();
            return modelTitle;
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

}
