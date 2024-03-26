package ru.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class Start {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("ru.spring");
        FileReader fileReader  =ctx.getBean("fileReader", FileReader.class);
        fileReader .getFiles();
    }
}
