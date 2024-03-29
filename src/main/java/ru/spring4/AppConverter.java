package ru.spring4;

import org.springframework.stereotype.Component;
import ru.spring.LogTransformation;

@LogTransformation
@Component
public class AppConverter {
    public static Logins checkApp(Logins logins){
        if(logins.application.contains("web")||logins.application.contains("mobile")) {
            return logins;
        }
        else{
            logins.application = "Others "+ logins.application;
        }
        return logins;
    }
}
