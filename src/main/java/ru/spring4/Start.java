package ru.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication(scanBasePackages = "ru.spring4")
public class Start {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Start.class);
        Handle hd = ctx.getBean(Handle.class);
        hd.make();
    }
}
