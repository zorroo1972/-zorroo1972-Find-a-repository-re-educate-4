package ru.spring4;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Entity
@Table(name = "Logins")
public class Logins
{
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "DATE_ACCESS")
    Date access_date;
    @Column(name = "USER_ID", nullable = false)
    long user_id;
    @Column(name = "APPLICATION", nullable = false)
    String application;

    public Logins() {
    }
    @Override
    public String toString() {
        return "Logins{" +
                "id=" + id +
                ", access_date=" + access_date +
                ", user_id=" + user_id +
                ", application='" + application + '\'' +
                '}';
    }
}


