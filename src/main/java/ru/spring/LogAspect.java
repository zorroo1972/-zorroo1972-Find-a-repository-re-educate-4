package ru.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

@Aspect
public class LogAspect {
    Date date = new Date();
    FileWriter writer = new FileWriter("C:\\Users\\zorro\\IdeaProjects\\re-educate-4\\src\\main\\resources\\Log\\log.txt");

    public LogAspect() throws IOException {
    }

    @Pointcut("execution(* *(..))")
    public void methodExecuting() {
    }
    @AfterReturning(value = "methodExecuting()", returning = "returningValue")
    public void recordSuccessfulExecution(JoinPoint joinPoint, Object returningValue) throws IOException {

        if (joinPoint.getSourceLocation().getWithinType().isAnnotationPresent(LogTransformation.class)){
            date = new Date();
            if (returningValue != null) {
                try {
                    writer.write(date+" Параметры - " +joinPoint.getArgs().toString()+ " Метод - " + joinPoint.getSignature().getName() +
                            ", класса - " + joinPoint.getSourceLocation().getWithinType().getName() +
                            " с результатом выполнения - " + returningValue+"\n");
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл: " + e.getMessage());
                }
            } else {
                try {
                    writer.write(date+" Параметры - " +joinPoint.getArgs().toString()+" Метод - " + joinPoint.getSignature().getName() +
                            ", класса - " + joinPoint.getSourceLocation().getWithinType().getName()+"\n");
                } catch (IOException e) {
                    System.out.println("Ошибка записи в файл: " + e.getMessage());
                }
            }
        }

    }
    @AfterThrowing(value = "methodExecuting()", throwing = "exception")
    public void recordFailedExecution(JoinPoint joinPoint, Exception exception) throws IOException {
        if (joinPoint.getSourceLocation().getWithinType().isAnnotationPresent(LogTransformation.class)) {
            date = new Date();
            try {
                writer.write(date+" Метод - " + joinPoint.getSignature().getName() +
                        ", класса- " + joinPoint.getSourceLocation().getWithinType().getName() +
                        "был аварийно завершен с исключением - " + exception+"\n");
            } catch (IOException e) {
                System.out.println("Ошибка записи в файл: " + e.getMessage());
            }
        }

    }

}
