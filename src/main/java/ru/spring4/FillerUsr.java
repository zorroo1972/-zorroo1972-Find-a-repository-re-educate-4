package ru.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.LogTransformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Consumer;

@LogTransformation
@Component
public class FillerUsr {
    @Autowired FioConverter fioConverter;
    @Autowired ImportFiles importFiles;
    @Autowired UsersRepo ur;
    Scanner sc;
    @Transactional
    public void accept() {
        String[] words;
        for (File file : importFiles.getFiles()) {
            if (file.isFile() & file.getName().contains("users")) {
                try {
                    ur.deleteAll();
                    sc = new Scanner(file);
                    while (sc.hasNextLine()) {
                        Users users = new Users();
                        words = sc.nextLine().split(";");
                        if (words.length > 1) {
                            for (String word : words) {
                                users.username = words[0];
                                users.fio = words[1];
                                ur.save(fioConverter.checkFio(users));
                            }
                        }
                    }
                    sc.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}


