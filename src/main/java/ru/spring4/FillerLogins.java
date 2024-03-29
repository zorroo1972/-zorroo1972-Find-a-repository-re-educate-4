package ru.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.LogTransformation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

@LogTransformation
@Component
public class FillerLogins {
    @Autowired
    AppConverter appConverter;
    @Autowired
    ImportFiles importFiles;
    @Autowired
    LoginsRepo lr;
    @Autowired
    DateConverter dateConvertor;
    @Autowired
    UsersRepo ur;
    Scanner sc;

    public void accept() {
        String[] words;
        for (File file : importFiles.getFiles()) {
            if (file.isFile() & file.getName().contains("logins")) {
                try {
                    lr.deleteAll();
                    sc = new Scanner(file);
                    while (sc.hasNextLine()) {
                        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                        Logins logins = new Logins();
                        words = sc.nextLine().split(";");
                        if (words.length > 1) {
                            for (String word : words) {
                                dateConvertor.string = words[0];
                                if(dateConvertor.check("File = " +file.getName()+" User = "+words[1] )==false) continue;
                                logins.access_date = formater.parse(words[0]);
                                Users users = new Users();
                                users = ur.findByUserName(words[1]);
                                logins.user_id = users.id;
                                logins.application = words[2];
                                logins = appConverter.checkApp(logins);
                                lr.save(logins);
                            }
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                sc.close();

            }
        }
    }
}






