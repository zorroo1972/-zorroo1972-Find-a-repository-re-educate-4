package ru.spring4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class Handle {
    @Autowired FillerUsr fillerUsr;
    @Autowired FillerLogins fillerLogins;
    Scanner sc;
    @Autowired UsersRepo ur;

    public void make()  {
        fillerUsr.accept();
        fillerLogins.accept();
    }
}
