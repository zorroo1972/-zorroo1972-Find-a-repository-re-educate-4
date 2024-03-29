package ru.spring4;

import org.springframework.stereotype.Component;
import ru.spring.LogTransformation;

@LogTransformation
@Component
public class FioConverter  {
    public static Users checkFio(Users users){
        String[] arr = users.fio.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = capitalize(arr[i]);
        }
        users.fio = getFio(arr);
        return  users;
    }
    private static String getFio(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s).append(" ");
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

}
